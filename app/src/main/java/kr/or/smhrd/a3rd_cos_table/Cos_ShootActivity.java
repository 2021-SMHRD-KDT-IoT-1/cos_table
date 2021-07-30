package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Cos_ShootActivity extends AppCompatActivity {
    TextView tv_cosshoot,tv_pdqr, tv_detail,tv_company,tv_kinds;
    Button btn_cancle,btn_shoot;
    ImageView img_ex2;
    IntentIntegrator qrScan;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_shoot);

        tv_cosshoot=findViewById(R.id.tv_cosshoot);
        tv_pdqr=findViewById(R.id.tv_pdqr);
        btn_cancle=findViewById(R.id.btn_cancle);
        btn_shoot=findViewById(R.id.btn_shoot);
        img_ex2=findViewById(R.id.img_ex2);

        tv_detail=findViewById(R.id.tv_detail);
        tv_company=findViewById(R.id.tv_company);
        tv_kinds=findViewById(R.id.tv_kinds);
        //qr스캔 정의
        qrScan = new IntentIntegrator(this);

        // 촬영 버튼 클릭시 qr촬영 액티비티(영광이형 제작 중)로 이동 후 촬영 완료 시 Cos_detail로 정보와 함께 이동
        btn_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
            }
        });

        // 취소 버튼을 클릭 시 다시 CosAdd페이지로 이동
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cos_ShootActivity.this, CosAddActivity.class);
                startActivity(intent);
            }
        });

    }



    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                Toast.makeText(Cos_ShootActivity.this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(Cos_ShootActivity.this, "스캔완료!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cos_ShootActivity.this, Cos_DetailActivity.class);//Cos_DetailActvity로 보내줌
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
//                    tv_detail.setText(obj.getString("제품명"));
//                    tv_company.setText(obj.getString("제조사"));
//                    tv_kinds.setText(obj.getString("제품종류"));


                    //나중에 화장품 상세보기에 xxxx.setText(obj.getString("xxx")); 하면 돼요

                    String scanResult = String.valueOf(qrScan); //qrScan을 String에 담아줌
                    String[] qrSplit=new String[4]; //qrScan을 -를 기준으로 잘라줄 변수
                    for (int i=0; i<qrSplit.length;i++) {
                        qrSplit[i]= String.valueOf(scanResult.split("-")); //-를 기준으로 잘라서 보관
                        Log.d("test","test="+qrSplit);

                    }


                    String u_cos_id =qrSplit[0];
//                    String id = qrSplit[1]; //이 둘은 다른 액티비티에서 가져와야 하는지 확인해야함
                    String cos_id=qrSplit[1];
                    String u_cos_date=qrSplit[2];
                    String amount = qrSplit[3];
                    String u_cos_dead = qrSplit[4];



                    if (qrSplit!=null) {

                        String cosAdd_url = "http://121.147.0.224:8081/AndServer/CosAddService";

                        StringRequest request = new StringRequest(Request.Method.POST, cosAdd_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        Log.v("응답결과", response);

                                        if (response.equals("1")) {
                                            Intent intent = new Intent(getApplicationContext(), Cos_DetailActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(Cos_ShootActivity.this, "화장품 등록 실패입니다.", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                        Log.v("오류", "요청실패");

                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();

                                params.put("u_cos_id", u_cos_id);
                                params.put("u_cos_date", u_cos_date);
                                params.put("amount", amount);
                                params.put("u_cos_dead", u_cos_dead);

                                return params;
                            }
                        };
                        queue.add(request);
                        //등록이 되지 않으면 토스트창에 표시
                    }else{
                        Toast.makeText(Cos_ShootActivity.this, "QR코드를 다시 찍어주세요.", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
//                    textViewResult.setText(result.getContents());
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
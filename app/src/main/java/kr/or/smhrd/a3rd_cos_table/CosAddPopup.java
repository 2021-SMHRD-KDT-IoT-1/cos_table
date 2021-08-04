package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CosAddPopup extends AppCompatActivity {

    TextView tv_add_amount;
    Button btn_amount_plus, btn_amount_minus, btn_amount_exit;
    RequestQueue queue;
    public static Context con_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add_popup);

        tv_add_amount=findViewById(R.id.tv_add_amount);
        btn_amount_plus=findViewById(R.id.btn_amount_plus);
        btn_amount_minus=findViewById(R.id.btn_amount_minus);
        btn_amount_exit=findViewById(R.id.btn_amount_exit);
        queue = Volley.newRequestQueue(getApplicationContext());

        con_amount=this;

        btn_amount_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. 텍스트뷰의 정보 가져오기
                String num = tv_add_amount.getText().toString();
                //2. 정수형 타입으로 변환 --> 증가
                int n = Integer.parseInt(num);
                n +=1;
                //3. 증가된 값 -->  텍스트뷰에 초기화
                // 정수형 --> 문자열 변환
                tv_add_amount.setText(String.valueOf(n));


            }
        });

        btn_amount_minus.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //1. 텍스트뷰의 정보 가져오기
                String num = tv_add_amount.getText().toString();


                //2. 정수형 타입으로 변환 --> 감소
                int n = Integer.parseInt(num);

                if(n>0) {
                    n-=1;
                }

                //3. 증가된 값 --> 텍스트뷰에 초기화
                //정수형 --> 문자열 변환
                tv_add_amount.setText(String.valueOf(n));
            }
        }));

        btn_amount_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    if (tv_add_amount != null) {
                        String cosAdd_url = "http://59.0.236.194:8099/AndServer/CosEdtService";
                        StringRequest request = new StringRequest(Request.Method.POST, cosAdd_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.v("응답결과", response);
                                        if (response.equals("1")) {

                                            Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                                            String num = tv_add_amount.getText().toString();
                                            //intent에 정보를 저장
                                            intent.putExtra("amount", num);
                                            Toast.makeText(getApplicationContext(),num,Toast.LENGTH_SHORT).show();

                                            startActivity(intent);
                                        } else {
                                            Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                                            String num = tv_add_amount.getText().toString();
                                            //intent에 정보를 저장
                                            intent.putExtra("amount", num);
                                            Log.d("test",intent.toString());
                                            startActivity(intent);
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
                                Map<String, String> params = new HashMap<String, String>();
                                String amount = String.valueOf(tv_add_amount.getText());

                                Intent u_cos_id = getIntent();

                                u_cos_id.getStringExtra("u_cos_id");
                                String a = "test123";
                                params.put("amount", amount);
                                params.put("u_cos_id", a);


                                return params;
                            }
                        };
                        queue.add(request);
                        //등록이 되지 않으면 토스트창에 표시
                    } else {
                        Toast.makeText(CosAddPopup.this, "수정버튼을 다시 눌러주세요.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
//                    textViewResult.setText(result.getContents());
                }


            }
        });


        }

}

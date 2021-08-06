package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Cos_DetailActivity extends AppCompatActivity {
    TextView tv_detail,tv_set, tv_dose, tv_brand, tv_type;
    Button btn_complete;
    RequestQueue queue;
    RadioButton rd_1, rd_2, rd_3, rd_4, rd_5, rd_6;
    String amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_detail);

        tv_detail=findViewById(R.id.tv_detail);
        tv_set=findViewById(R.id.tv_set);
        tv_dose=findViewById(R.id.tv_dose);
        tv_brand=findViewById(R.id.tv_brand);
        tv_type = findViewById(R.id.tv_type);

        //라디오버튼
        rd_1=findViewById(R.id.rd_1);
        rd_2=findViewById(R.id.rd_2);
        rd_3=findViewById(R.id.rd_3);
        rd_4=findViewById(R.id.rd_4);
        rd_5=findViewById(R.id.rd_5);
        rd_6=findViewById(R.id.rd_6);


        btn_complete = findViewById(R.id.btn_complete);

        Intent intent = getIntent();
        String cos_id = intent.getStringExtra("cos_id");
        String u_cos_id=intent.getStringExtra("u_cos_id");

        queue = Volley.newRequestQueue(getApplicationContext());

       String listview_url = "http://59.0.236.194:8099/AndServer/CosDetailService";
        StringRequest request = new StringRequest(Request.Method.POST, listview_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과", response);



                        try {
                                JSONObject jsonObject = new JSONObject(response);
                                String cos_name = jsonObject.getString("cos_name");
                                String cos_brand = jsonObject.getString("cos_brand");
                                String cos_type = jsonObject.getString("cos_type");

                                Log.v("응답결과", cos_name + "/" + cos_brand+"/"+cos_type);

                                tv_detail.setText(cos_name.toString());
                                tv_brand.setText(cos_brand.toString());
                                tv_type.setText(cos_type.toString());



                        } catch (JSONException e) {
                            e.printStackTrace();
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

                params.put("cos_id",cos_id);

                return params;
            }
        };

        queue.add(request);



        rd_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="0.5";
            }
        });
        rd_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="1.0";
            }
        });
        rd_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="1.5";
            }
        });
        rd_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="2.0";
            }
        });
        rd_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="2.5";
            }
        });
        rd_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount="3.0";
            }
        });

        
        // 등록완료 버튼 클릭 시 정보와 함께 다시 cos_add 페이지로 이동
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                intent.putExtra("u_cos_id",u_cos_id);
                startActivity(intent);
                try {
                    if (true) {
                        String cosAdd_url = "http://59.0.236.194:8099/AndServer/CosEdtService";
                        StringRequest request = new StringRequest(Request.Method.POST, cosAdd_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.v("응답결과", response);
                                        if (response.equals("1")) {

                                            Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);

//                                            String num = tv_add_amount.getText().toString();
                                            String num= String.valueOf(amount);
                                            //intent에 정보를 저장
                                            intent.putExtra("amount", amount);

                                            Toast.makeText(getApplicationContext(),num,Toast.LENGTH_SHORT).show();

                                            startActivity(intent);
                                        } else {
                                            Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                                            String num= String.valueOf(amount);
                                            //intent에 정보를 저장
                                            intent.putExtra("amount", amount);

                                            Toast.makeText(getApplicationContext(),num,Toast.LENGTH_SHORT).show();

//                                            startActivity(intent);
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
//                                String amount = String.valueOf(tv_add_amount.getText());

                                Intent u_cos_id = getIntent();

                                String ucosid=u_cos_id.getStringExtra("u_cos_id");

//                                Intent intent_ucid = new Intent(getApplicationContext(), CosDeletePopup.class);
//                                intent_ucid.putExtra(u_cos_id);
//                                startActivity(intent_ucid);

                                String a = "test123";
                                params.put("amount", amount);
                                params.put("u_cos_id", ucosid);


                                return params;
                            }
                        };
                        queue.add(request);
                        //등록이 되지 않으면 토스트창에 표시
                    } else {
                        Toast.makeText(Cos_DetailActivity.this, "수정버튼을 다시 눌러주세요.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
//                    textViewResult.setText(result.getContents());
                }
            }
        });

        tv_dose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Cos_DetailActivity.this);
                dlg.setTitle("제형 별 정량"); //제목
                dlg.setMessage("크림 0.5펌프"  +"\n"+ "로션 1펌프" +"\n"+ "스킨 1.5펌프"); // 메시지
//                버튼 클릭시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();
            }
        });




    }
}
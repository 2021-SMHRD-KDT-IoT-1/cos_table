package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CosAddPopup extends AppCompatActivity {

    TextView tv_add_amount;
    Button btn_amount_plus, btn_amount_minus, btn_amount_exit,btn_cosdelete;
    RequestQueue queue;
    private String num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add_popup);

        tv_add_amount=findViewById(R.id.tv_add_amount);
        btn_amount_plus=findViewById(R.id.btn_amount_plus);
        btn_amount_minus=findViewById(R.id.btn_amount_minus);
        btn_amount_exit=findViewById(R.id.btn_amount_exit);

        btn_cosdelete=findViewById(R.id.btn_cosdelete);

        queue = Volley.newRequestQueue(getApplicationContext());

        Intent intent = getIntent();
        String cos_id = intent.getStringExtra("cos_id");
        String u_cos_id = intent.getStringExtra("u_cos_id");
        String amount = intent.getStringExtra("amount");
        String id = intent.getStringExtra("id");

        Log.v("intent로 받아온 값", cos_id+", "+u_cos_id+", "+amount+", "+id);

        tv_add_amount.setText(amount);


        btn_amount_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. 텍스트뷰의 정보 가져오기
                num = tv_add_amount.getText().toString();

                //2. 실수형 타입으로 변환 --> 증가
                double n = Double.parseDouble(num);

                if (n<=3) {
                    n += 0.5;
                }

                //3. 증가된 값 -->  텍스트뷰에 초기화
                // 정수형 --> 문자열 변환
                tv_add_amount.setText(String.valueOf(n));
            }
        });

        btn_amount_minus.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //1. 텍스트뷰의 정보 가져오기
                num = tv_add_amount.getText().toString();

                //2. 실수형 타입으로 변환 --> 감소
                double n = Double.parseDouble(num);

                if(n > 0) {
                    n -= 0.5;
                }

                //3. 증가된 값 --> 텍스트뷰에 초기화
                //살수형 --> 문자열 변환
                tv_add_amount.setText(String.valueOf(n));
            }
        }));

        btn_amount_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String cosAdd_url = "http://220.71.97.208:8099/AndServer/CosEdtService";
                        StringRequest request = new StringRequest(Request.Method.POST, cosAdd_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.v("CosEdtService 응답결과", response);

                                        if (response.equals("1")) {

                                            Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                                            //intent에 정보를 저장
                                            intent.putExtra("cos_id", cos_id);
                                            intent.putExtra("u_cos_id", u_cos_id);
                                            intent.putExtra("amount", tv_add_amount.getText());
                                            intent.putExtra("id", id);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(CosAddPopup.this, "1회 사용량 수정 실패!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                        Log.v("CosAddPopup 오류", "요청실패");
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();


                                params.put("amount", tv_add_amount.getText().toString());
                                params.put("u_cos_id", u_cos_id);

                                Log.v("params로 보내는 값", u_cos_id + ", "+ amount);

                                return params;
                            }
                        };
                        queue.add(request);
            }
        });

        btn_cosdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteintent = new Intent(getApplicationContext(),CosDeletePopup.class);
                deleteintent.putExtra("cos_id", cos_id);
                deleteintent.putExtra("u_cos_id", u_cos_id);
                deleteintent.putExtra("amount", amount);
                deleteintent.putExtra("id", id);
                startActivity(deleteintent);
            }
        });

        }

}

package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class cos_login extends AppCompatActivity {

    EditText edt_login_id, edt_login_pw;
    Button btn_login;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_login);

        edt_login_id = findViewById(R.id.edt_login_id);
        edt_login_pw = findViewById(R.id.edt_login_pw);
        btn_login = findViewById(R.id.btn_login);

        queue= Volley.newRequestQueue(getApplicationContext());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=edt_login_id.getText().toString();

                String login_url="http://220.71.97.208:8099/AndServer/LoginService";

                    StringRequest request= new StringRequest(Request.Method.POST, login_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("응답결과", response);

                                if(response.equals("0")){
                                    Toast.makeText(cos_login.this, "로그인 실패..", Toast.LENGTH_SHORT).show();
                                    //실패시 다시 로그인 화면으로 이동
                                    Intent intent = new Intent(cos_login.this, cos_login.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(cos_login.this, "로그인 성공!!", Toast.LENGTH_SHORT).show();
                                    //성공시 메인 페이지로 이동
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("오류", "오류입니다.");
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            //POST 방식일 때 getParams() 메소드를 이용해 데이터 전송
                            Map<String, String> params=new HashMap<>();
                            params.put("login_id",edt_login_id.getText().toString());
                            params.put("login_pw",edt_login_pw.getText().toString());

                            return params;
                        }
                    };
                queue.add(request);
            }
        });

    }
}
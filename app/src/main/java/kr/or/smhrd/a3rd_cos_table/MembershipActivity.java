package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MembershipActivity extends AppCompatActivity {
    EditText edt_mem_id,edt_mem_pw,edt_mem_pwck;
    TextView tv_skintype,tv_ck_mytype,tv_ck_sensitive,tv_Q1,tv_Q2;
    Button btn_mem_join;
    RadioGroup rd_btn_group;
    RadioButton rd_btn_dry, rd_btn_oily, rd_btn_normal, rd_btn_multi;
    RequestQueue queue;

    private String rd_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        edt_mem_id=findViewById(R.id.edt_mem_id);
        edt_mem_pw=findViewById(R.id.edt_mem_pw);
        edt_mem_pwck=findViewById(R.id.edt_mem_pwck);

        tv_skintype=findViewById(R.id.tv_skintype);
        tv_ck_mytype=findViewById(R.id.tv_ck_mytype);
        tv_ck_sensitive=findViewById(R.id.tv_ck_sensitive);

        btn_mem_join=findViewById(R.id.btn_mem_join);

        rd_btn_group=findViewById(R.id.rd_btn_group);
        rd_btn_dry=findViewById(R.id.rd_btn_dry);
        rd_btn_oily=findViewById(R.id.rd_btn_oily);
        rd_btn_normal=findViewById(R.id.rd_btn_normal);
        rd_btn_multi=findViewById(R.id.rd_btn_multi);

        queue = Volley.newRequestQueue(getApplicationContext());

        //내 피부타입이 궁금하다면? -- 버튼 클릭 시 자가진단 테스트로 이동
        tv_ck_mytype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SkintestActivity.class);
                startActivity(intent);
            }
        });
//=========================================================================================================
        //라디오버튼 값 넘기기위한 이벤트
        rd_btn_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rd_btn_dry){
                    rd_result = rd_btn_dry.getText().toString();
                }else if (checkedId == R.id.rd_btn_oily){
                    rd_result = rd_btn_oily.getText().toString();
                }else if (checkedId == R.id.rd_btn_normal){
                    rd_result = rd_btn_normal.getText().toString();
                }else {
                    rd_result = rd_btn_multi.getText().toString();
                }
            }
        });
//=========================================================================================================
        //회원가입 버튼 클릭 시 피부타입이 null값이라면 토스트 메시지 출력!
//        btn_mem_join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(rd_result != null){
//                    Toast.makeText(MembershipActivity.this, rd_result, Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MembershipActivity.this, "피부타입을 선택해주세요!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//=========================================================================================================
        //회원가입 정보 DB연동
        btn_mem_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edt_mem_id.getText().toString();
                String pw = edt_mem_pw.getText().toString();
                String skintype = rd_result;

                String join_url = "http://220.71.97.208:8099/AndServer/JoinService";

                StringRequest request = new StringRequest(Request.Method.POST, join_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Log.v("응답결과", response);

                                if (response.equals("1")){
                                    Intent intent = new Intent(getApplicationContext(), cos_login.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MembershipActivity.this, "회원가입 실패입니다.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.v("오류","요청실패");

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("join_id",id);
                        params.put("join_pw",pw);
                        params.put("join_skintype",skintype);

                        return params;
                    }
                };
                queue.add(request);
            }
        });
        //=========================================================================================================
    }
}
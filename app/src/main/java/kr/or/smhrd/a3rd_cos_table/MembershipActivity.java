package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MembershipActivity extends AppCompatActivity {
    EditText edt_mem_id,edt_mem_pw,edt_mem_pwck;
    TextView tv_skintype,tv_ck_mytype,tv_ck_sensitive,tv_Q1,tv_Q2;
    Button btn_mem_join;
    RadioButton rd_btn_dry,rd_btn_oily,rd_btn_normal,rd_btn_multi;


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


        //내 피부타입이 궁금하다면? -- 버튼 클릭 시 자가진단 테스트로 이동
        tv_ck_mytype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SkintestActivity.class);
                startActivity(intent);
            }
        });
    }
}







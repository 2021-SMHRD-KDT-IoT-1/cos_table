package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MembershipActivity extends AppCompatActivity {
    EditText edt_mem_id,edt_mem_pw,edt_mem_pwck;
    TextView tv_skintype,tv_ck_mytype,tv_ck_sensitive,tv_Q1,tv_Q2;
    Button btn_dry,btn_normal,btn_oily,btn_combi,btn_mem_join;

//    boolean isClicked=false;
//    //boolean isClicked=false;

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

        btn_dry=findViewById(R.id.btn_dry);
        btn_normal=findViewById(R.id.btn_normal);
        btn_oily=findViewById(R.id.btn_oily);
        btn_combi=findViewById(R.id.btn_combi);
        btn_mem_join=findViewById(R.id.btn_mem_join);

        //내 피부타입이 궁금하다면? -- 버튼 클릭 시 자가진단 테스트로 이동
        tv_ck_mytype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SkintestActivity.class);
                startActivity(intent);
            }
        });
        // -------------------------------------------------------------
        
//        //타입별 토글버튼 구현
//        btn_dry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!isClicked){
//                    btn_dry.setBackgroundColor(Color.CYAN);
//                }else{
//                    //btn_dry.setBackgroundColor(Color.GRAY);
//                }
//            }
//        });
//
//        btn_normal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isClicked==false){
//                    isClicked=true;
//                    btn_normal.setBackgroundColor(Color.CYAN);
//                }else{
//                    isClicked=false;
//                    btn_normal.setBackgroundColor(Color.GRAY);
//                }
//            }
//        });
//
//        btn_oily.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isClicked==false){
//                    isClicked=true;
//                    btn_oily.setBackgroundColor(Color.CYAN);
//                }else{
//                    isClicked=false;
//                    btn_oily.setBackgroundColor(Color.GRAY);
//                }
//            }
//        });
//
//        btn_combi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isClicked==false){
//                    isClicked=true;
//                    btn_combi.setBackgroundColor(Color.CYAN);
//                }else{
//                    isClicked=false;
//                    btn_combi.setBackgroundColor(Color.GRAY);
//                }
//            }
//        });


    }

}







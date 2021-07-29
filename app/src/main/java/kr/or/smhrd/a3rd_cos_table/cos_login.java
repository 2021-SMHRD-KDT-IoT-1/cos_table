package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cos_login extends AppCompatActivity {

    EditText edt_login_id, edt_login_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_login);

        edt_login_id = findViewById(R.id.edt_login_id);
        edt_login_pw = findViewById(R.id.edt_login_pw);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=edt_login_id.getText().toString();
                String pw=edt_login_pw.getText().toString();


                if(id.equals("smhrd")&& pw.equals("1234")) {

                    //Intent 객체 생성
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    //정보저장
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });



    }
}
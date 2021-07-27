package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cos_intro_activity extends AppCompatActivity {

    Button btn_go_login, btn_go_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_intro);

        btn_go_login = findViewById(R.id.btn_go_login);
        btn_go_join = findViewById(R.id.btn_go_join);


        btn_go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cos_login.class);
                startActivity(intent);
            }
        });

    }
}
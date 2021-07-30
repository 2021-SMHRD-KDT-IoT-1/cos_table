package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CosAddActivity extends AppCompatActivity {

    Button btn_add, btn_edt, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add);

        btn_add = findViewById(R.id.btn_add);
        btn_edt = findViewById(R.id.btn_edt);
        btn_delete = findViewById(R.id.btn_delete);

        // 등록 버튼 클릭 시 Cos_Shoot페이지로 이동
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CosAddActivity.this, Cos_ShootActivity.class);
                startActivity(intent);
            }
        });

    }
}
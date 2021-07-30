package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cos_DetailActivity extends AppCompatActivity {
    TextView tv_detail,tv_set;
    Button btn_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_detail);

        tv_detail=findViewById(R.id.tv_detail);
        tv_set=findViewById(R.id.tv_set);

        btn_complete = findViewById(R.id.btn_complete);

        
        // 등록완료 버튼 클릭 시 정보와 함께 다시 cos_add 페이지로 이동
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                startActivity(intent);
            }
        });

    }
}
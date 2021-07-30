package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cos_ShootActivity extends AppCompatActivity {
    TextView tv_cosshoot,tv_pdqr;
    Button btn_cancle,btn_shoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_shoot);

        tv_cosshoot=findViewById(R.id.tv_cosshoot);
        tv_pdqr=findViewById(R.id.tv_pdqr);
        btn_cancle=findViewById(R.id.btn_cancle);
        btn_shoot=findViewById(R.id.btn_shoot);

        // 촬영 버튼 클릭시 qr촬영 액티비티(영광이형 제작 중)로 이동 후 촬영 완료 시 Cos_detail로 정보와 함께 이동
        btn_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        // 취소 버튼을 클릭 시 다시 CosAdd페이지로 이동
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cos_ShootActivity.this, CosAddActivity.class);
                startActivity(intent);
            }
        });

    }
}
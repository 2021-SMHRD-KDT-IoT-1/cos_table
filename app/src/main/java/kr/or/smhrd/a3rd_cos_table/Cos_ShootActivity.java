package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}
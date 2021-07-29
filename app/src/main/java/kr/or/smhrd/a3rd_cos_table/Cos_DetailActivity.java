package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Cos_DetailActivity extends AppCompatActivity {
    TextView tv_detail,tv_set;
    Button btn_0_5,btn_1_0,btn_1_5,btn_2_0,btn_2_5,btn_3_0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_detail);

        tv_detail=findViewById(R.id.tv_detail);
        tv_set=findViewById(R.id.tv_set);

        btn_0_5=findViewById(R.id.btn_0_5);
        btn_1_0=findViewById(R.id.btn_1_0);
        btn_1_5=findViewById(R.id.btn_1_5);
        btn_2_0=findViewById(R.id.btn_2_0);
        btn_2_5=findViewById(R.id.btn_2_5);
        btn_3_0=findViewById(R.id.btn_3_0);
    }
}
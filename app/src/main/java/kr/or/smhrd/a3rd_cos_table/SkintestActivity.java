package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SkintestActivity extends AppCompatActivity {
    TextView tv_test_skin;
    Button btn_test_no,btn_test_back,btn_test_yes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skintest);

        tv_test_skin=findViewById(R.id.tv_test_skin);
        btn_test_no=findViewById(R.id.btn_test_no);
        btn_test_back=findViewById(R.id.btn_test_back);
        btn_test_yes=findViewById(R.id.btn_test_yes);


    }
}
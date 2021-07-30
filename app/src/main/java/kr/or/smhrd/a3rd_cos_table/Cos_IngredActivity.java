package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cos_IngredActivity extends AppCompatActivity {

    TextView tv_Cos_content,tv_Cos_Ingred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_ingred);

        tv_Cos_content=findViewById(R.id.tv_Cos_content);
        tv_Cos_Ingred=findViewById(R.id.tv_Cos_Ingred);
    }
}
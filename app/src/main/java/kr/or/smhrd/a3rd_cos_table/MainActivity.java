package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_main_id;
    TextView tv_mycos,tv_usedate1,tv_usedate2,tv_usedate3,tv_usedcos;
    ListView ListV_cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_main_id=findViewById(R.id.edt_main_id);
        tv_mycos=findViewById(R.id.tv_mycos);
        tv_usedate1=findViewById(R.id.tv_usedate1);
        tv_usedate2=findViewById(R.id.tv_usedate2);
        tv_usedate3=findViewById(R.id.tv_usedate3);
        tv_usedcos=findViewById(R.id.tv_usedcos);

        ListV_cos=findViewById(R.id.ListV_cos);


    }
}
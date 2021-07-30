package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_main_id;
    TextView tv_mycos,tv_usedate1,tv_usedate2,tv_usedate3,tv_usedcos;
    ImageButton img_mycos1, img_mycos2, img_mycos3;
    Button btn_plus;
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
        btn_plus=findViewById(R.id.btn_plus);

        ListV_cos=findViewById(R.id.ListV_cos);

        //로그인 시 userid 출력
        String id=getIntent().getStringExtra("id");
        edt_main_id.setText(id+"님 환영합니다!");


        //내 화장품 옆에 + 클릭시 화장품 등록 페이지로 이동
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                startActivity(intent);
            }
        });



    }
}
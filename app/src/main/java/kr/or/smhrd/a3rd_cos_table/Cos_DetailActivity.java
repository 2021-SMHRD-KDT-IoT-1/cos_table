package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cos_DetailActivity extends AppCompatActivity {
    TextView tv_detail,tv_set, tv_dose;
    Button btn_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_detail);

        tv_detail=findViewById(R.id.tv_detail);
        tv_set=findViewById(R.id.tv_set);
        tv_dose=findViewById(R.id.tv_dose);

        btn_complete = findViewById(R.id.btn_complete);

        
        // 등록완료 버튼 클릭 시 정보와 함께 다시 cos_add 페이지로 이동
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                startActivity(intent);
            }
        });

        tv_dose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Cos_DetailActivity.this);
                dlg.setTitle("제형 별 정량"); //제목
                dlg.setMessage("크림 0.5펌프"  +"\n"+ "로션 1펌프" +"\n"+ "스킨 1.5펌프"); // 메시지
//                버튼 클릭시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(Cos_DetailActivity.this,"확인을 눌르셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

    }
}
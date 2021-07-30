package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class Cos_ShootActivity extends AppCompatActivity {
    TextView tv_cosshoot,tv_pdqr, tv_detail,tv_company,tv_kinds;
    Button btn_cancle,btn_shoot;
    ImageView img_ex2;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_shoot);

        tv_cosshoot=findViewById(R.id.tv_cosshoot);
        tv_pdqr=findViewById(R.id.tv_pdqr);
        btn_cancle=findViewById(R.id.btn_cancle);
        btn_shoot=findViewById(R.id.btn_shoot);
        img_ex2=findViewById(R.id.img_ex2);

        tv_detail=findViewById(R.id.tv_detail);
        tv_company=findViewById(R.id.tv_company);
        tv_kinds=findViewById(R.id.tv_kinds);
        //qr스캔 정의
        qrScan = new IntentIntegrator(this);

        // 촬영 버튼 클릭시 qr촬영 액티비티(영광이형 제작 중)로 이동 후 촬영 완료 시 Cos_detail로 정보와 함께 이동
        btn_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
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



    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                Toast.makeText(Cos_ShootActivity.this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(Cos_ShootActivity.this, "스캔완료!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cos_ShootActivity.this, Cos_DetailActivity.class);//Cos_DetailActvity로 보내줌
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
                    tv_detail.setText(obj.getString("제품명"));
                    tv_company.setText(obj.getString("제조사"));
                    tv_kinds.setText(obj.getString("제품종류"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
//                    textViewResult.setText(result.getContents());
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
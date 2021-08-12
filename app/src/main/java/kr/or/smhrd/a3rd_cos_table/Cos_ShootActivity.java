package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Cos_ShootActivity extends AppCompatActivity {
    TextView tv_cosshoot, tv_pdqr;
    Button btn_cancle, btn_shoot;
    ImageView img_ex1, img_ex2;
    IntentIntegrator qrScan;
    RequestQueue queue;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_shoot);

        //뷰 초기화
        tv_cosshoot = findViewById(R.id.tv_cosshoot);
        tv_pdqr = findViewById(R.id.tv_pdqr);

        btn_cancle = findViewById(R.id.btn_cancle);
        btn_shoot = findViewById(R.id.btn_shoot);

        img_ex2 = findViewById(R.id.img_ex);

        //qr스캔 정의
        qrScan = new IntentIntegrator(this);
        queue = Volley.newRequestQueue(getApplicationContext());

        //intent.getStringExtra 값 받아오기
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        // 촬영 버튼 클릭시 qr촬영 액티비티(영광이형 제작 중)로 이동 후 촬영 완료 시 Cos_detail로 정보와 함께 이동
        btn_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
                Log.v("result scanning", "result scanning");

//                Intent intent = new Intent(getApplicationContext(), Cos_DetailActivity.class);
//                startActivity(intent);
            }
        });

        // 취소 버튼을 클릭 시 다시 CosAdd페이지로 이동
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cos_ShootActivity.this, CosAddActivity.class);
                intent.putExtra("id", id);
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
                Toast.makeText(Cos_ShootActivity.this, "큐알 인식 실패!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(Cos_ShootActivity.this, "스캔 완료!", Toast.LENGTH_SHORT).show();
                String scanResult = result.getContents();

                Log.v("화장품 정보", scanResult);

                Intent intent = new Intent(getApplicationContext(), Cos_DetailActivity.class);//Cos_DetailActvity로 보내줌
                intent.putExtra("id", id);
                intent.putExtra("scanResult", scanResult);
                startActivity(intent);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
package kr.or.smhrd.a3rd_cos_table;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//import kr.or.smhrd.a3rd_cos_table.cos_img.img_1st;

public class CosAddActivity extends AppCompatActivity {

    Button btn_add, btn_edt;
    ImageView img_1st_add, img_2nd_add, img_3rd_add;
    TextView tv_add_info,tv_add_img1,tv_add_img2,tv_add_img3;
    Dialog add_amountedt;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add);

        btn_add = findViewById(R.id.btn_add);
        btn_edt = findViewById(R.id.btn_edt);

        img_1st_add=(ImageView)findViewById(R.id.img_1st_add);
        img_2nd_add=(ImageView)findViewById(R.id.img_2nd_add);
        img_3rd_add=(ImageView)findViewById(R.id.img_3rd_add);

        queue = Volley.newRequestQueue(getApplicationContext());

        Intent intent = getIntent();
        String imgCheck = intent.getStringExtra("imgCheck");
        if(imgCheck != null){
            img_1st_add.setImageResource(R.drawable.plus);

        }

        //이미지뷰에 사진 출력
        // resource 폴더에 저장된 파일을 bitmap으로 만들어 리턴해주는 함수
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.imgsample1);
        img_1st_add.setImageBitmap(bitmap);
        // drawable/ 폴더의 image_sample 이미지를 load하여 출력하는 방식
        img_2nd_add.setImageResource(R.drawable.imgsample1);
        img_3rd_add.setImageResource(R.drawable.imgsample1);

        tv_add_img1=findViewById(R.id.tv_add_img1);
        tv_add_img2=findViewById(R.id.tv_add_img2);
        tv_add_img3=findViewById(R.id.tv_add_img3);

        // 등록 버튼 클릭 시 Cos_Shoot페이지로 이동
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CosAddActivity.this, Cos_ShootActivity.class);
                startActivity(intent);
            }
        });

        //================================================================================================
        img_1st_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(CosAddActivity.this, CosAddPopup.class);
                Intent intent_amount = getIntent();
                String uCos_text= intent.getStringExtra("amount");
                tv_add_img1.setText(uCos_text);
                startActivity(intent);

            }

        });

        img_2nd_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CosAddActivity.this,CosAddPopup.class);
                startActivity(intent);
            }
        });

        img_3rd_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CosAddActivity.this,CosAddPopup.class);
                startActivity(intent);

            }
        });

    }
}
package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class CosAddActivity extends AppCompatActivity {

    Button btn_add, btn_edt, btn_delete;
    ImageView img_1st_add, img_2nd_add, img_3rd_add, img_4th_add;
    TextView tv_add_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add);

        btn_add = findViewById(R.id.btn_add);
        btn_edt = findViewById(R.id.btn_edt);
        btn_delete = findViewById(R.id.btn_delete);

        img_1st_add=findViewById(R.id.img_1st_add);
        img_2nd_add=findViewById(R.id.img_2nd_add);
        img_3rd_add=findViewById(R.id.img_3rd_add);
        img_4th_add=findViewById(R.id.img_4th_add);



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
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);

                getMenuInflater().inflate(R.menu.img1_add, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId()==R.id.act_cos_ingred) {
                            Toast.makeText(CosAddActivity.this, "화장품 상세 정보",Toast.LENGTH_SHORT).show();
                        }else if (item.getItemId()==R.id.act_insert) {
                            Toast.makeText(CosAddActivity.this, "수정",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CosAddActivity.this, "삭제",Toast.LENGTH_SHORT).show();
                        }
                        //

                        return false;
                    }
                });
                popupMenu.show();
            }


        });


    }
}
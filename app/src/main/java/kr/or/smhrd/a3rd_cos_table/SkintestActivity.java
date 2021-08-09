package kr.or.smhrd.a3rd_cos_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kr.or.smhrd.a3rd_cos_table.SkinTypeFrag.bok;
import kr.or.smhrd.a3rd_cos_table.SkinTypeFrag.gun;
import kr.or.smhrd.a3rd_cos_table.SkinTypeFrag.jisung;
import kr.or.smhrd.a3rd_cos_table.SkinTypeFrag.jung;

public class SkintestActivity extends AppCompatActivity {
    TextView tv_test_skin;
    Button btn_test_no,btn_test_back,btn_test_yes;
    BottomNavigationView navigation;
    FrameLayout frame;

    bok frg_bok;
    gun frg_gun;
    jisung frg_jisung;
    jung frg_jung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skintest);

//        frame = findViewById(R.id.frame); //이거 초기화

        navigation = findViewById(R.id.navigation);
        frg_gun = new gun();
        frg_bok = new bok();
        frg_jisung = new jisung();
        frg_jung = new jung();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, frg_jung).commit();

        //여기까지 프레임 초기화하고 프레그먼트 출력까지 되는데 클릭이 안되는 것 같아
        //일단 테스트 한번만 해보고 원인을 찾자

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.item_jung) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, frg_jung).commit();
                }else if (itemId==R.id.item_jisung) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, frg_jisung).commit();
                }else if (itemId==R.id.item_gun) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, frg_gun).commit();
                }else if (itemId==R.id.item_bok) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, frg_bok).commit();
                }

                //true : 클릭한 메뉴아이템에 포커싱
                return true;
            }
        });
    }
}
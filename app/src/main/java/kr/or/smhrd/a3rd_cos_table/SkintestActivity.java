package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        //체크리스트부분////////////////////////////////////////////////


        ///////////////////////////////////////////////
        //질문리스트 선언
      /*  String Q1= "Q1.피부가 좋아 보인다는 말을 자주 듣는 편이다.";
        String Q2="Q2.얼굴과 몸에 뾰루지가 잘 생기는 편이다.";
        String Q3="Q3.하루만 머리를 안 감아도 비듬이 생기고 가렵다.";
        String Q4="Q4.하루만 샤워를 안 해도 끈적거리고 냄새가 난다.";
        String Q5="Q5.눈가와 입 주변이 거뭇거뭇하고 오돌토돌하게 튀어나온 것이 있다.";
        String Q6="Q6.팔뚝과 허벅지에 닭살이 많은 편이다.";
        String Q7="Q7.T존 부위가 항상 번들거린다.";
        String Q8="Q8.세안 후 피부가 당기고 각질이 일어난다.";
        String Q9="Q9.화장이 잘 뜨고 쉽게 지워지는 편이다.";
        String Q10="Q10.코에 검은 피지가 많은 편이다.";
        String Q11="Q11.겨울이 되면 피부가 더 잘 튼다.";
        String Q12="Q12.계절이 바뀔 때마다 피부 트러블이 생긴다.";
        String Q13="Q13.피부가 얇고 건조한 편이다.";
        String Q14="Q14.화장품은 민감성용만 골라 쓰는 편이다.";
        String Q15="Q15.햇빛 알레르기가 있다(햇빛 노출 시 자극반응)";
        String Q16="Q16.각질 때문에 항상 크림이나 보습제를 챙겨 바른다.";
        String Q17="Q17.끈적임이 싫어 가능하면 스킨케어 제품을 최소한으로 사용하는 편이다.";
        String Q18="Q18.오랜만에 신경써서 마사지를 하고 나면 트러블이 올라온다.";
        String Q19="Q19.얼굴이 잘 붉어진다.";
        String Q20="Q20.피부에 잔주름이 많다.";
        String Q21="Q21.화장품을 바꾸면 트러블이 잘 생긴다.";
        String Q22="Q22.얼굴과 몸에 털이 많은 편이다.";
        String Q23="Q23.아침에는 피부가 밝아 보이는데 오후로 갈수록 점점 칙칙해진다.";
        String Q24="Q24.모공이 넓은 편이다."; */
        /////////////////////////////////////////////////////

//        tv_que.setText(Q1);
//        if (tv_que.getText().equals(Q1)) {

        btn_test_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_test_skin.setText("dddd");
            }
        });
        btn_test_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_test_skin.setText("a");
            }
        });
//        }


    }
}
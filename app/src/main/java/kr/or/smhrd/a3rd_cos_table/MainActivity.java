package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_main_id;
    TextView tv_mycos,tv_usedate1,tv_usedate2,tv_usedate3,tv_usedcos;
    ImageButton img_mycos1, img_mycos2, img_mycos3;
    Button btn_plus;

    RequestQueue queue;

    //사용한 화장품 list
    private ListView ListV_cos;
    private CoslistAdapter adapter;
    private ArrayList<CoslistVO> data;

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

        img_mycos1=findViewById(R.id.img_mycos1);
        img_mycos2=findViewById(R.id.img_mycos2);
        img_mycos3=findViewById(R.id.img_mycos3);



        queue= Volley.newRequestQueue(getApplicationContext());

        //listview값에 화장품 기한, 사용기한 정보 db에서 받아오기
        String listview_url="http://220.71.97.208:8099/AndServer/CosListService";
        StringRequest request=new StringRequest(Request.Method.GET, listview_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답결과", response);

                        //response 객체에는 JSONArray 형태 정보가 담겨있기 때문에
                        //JSONArray타입으로 객체 생성 필요
                        try {

                            JSONArray array=new JSONArray(response);
                            StringBuilder builder=new StringBuilder();

                            for(int i=0;i<array.length();i++){
                                JSONObject cos=(JSONObject)array.get(i);
                                builder.append("화장품이름 : ");
                                builder.append(cos.getString("cosname"));
                                builder.append("\n 사용기한 : ");
                                builder.append(cos.getString("date"));
                                builder.append("\n");
                            }
//                            tv_list_cosname.setText(builder.toString());
//                            tv_list_date.setText(builder.toString());



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        //===사용했던 화장품 list=========================================================================
        ListV_cos=findViewById(R.id.ListV_cos);
        data=new ArrayList<>();
        for(int i=0;i<10;i++){
//            data.add(new CoslistVO("cosname","date","완료/중단 결과"));
        }

        adapter=new CoslistAdapter(getApplicationContext(),
                R.layout.list_cositem,
                data);

        ListV_cos.setAdapter(adapter);
        //================================================================================

        //로그인 시 userid 출력
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
//        String id=getIntent().getStringExtra("login_id");
        edt_main_id.setText(id+"님 환영합니다!");


        //내 화장품 옆에 + 클릭시 화장품 등록 페이지로 이동
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                startActivity(intent);
            }
        });

        // 내 화장품1 클릭시 상세페이지(cos_Ingred) 이동 -> 화장품 1에 대한 자료화면으로 넘어가야함
        img_mycos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cos_IngredActivity.class);
                startActivity(intent);
            }
        });
  }
}
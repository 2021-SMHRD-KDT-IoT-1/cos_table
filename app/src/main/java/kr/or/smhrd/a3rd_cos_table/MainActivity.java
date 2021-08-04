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

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edt_main_id;
    TextView tv_mycos,tv_usedate1,tv_usedate2,tv_usedate3,tv_usedcos, tv_list;
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
         edt_main_id = findViewById(R.id.edt_main_id);
         tv_mycos = findViewById(R.id.tv_mycos);
         tv_usedate1 = findViewById(R.id.tv_usedate1);
         tv_usedate2 = findViewById(R.id.tv_usedate2);
         tv_usedate3 = findViewById(R.id.tv_usedate3);
         tv_usedcos = findViewById(R.id.tv_usedcos);

         btn_plus = findViewById(R.id.btn_plus);

         img_mycos1 = findViewById(R.id.img_mycos1);
         img_mycos2 = findViewById(R.id.img_mycos2);
         img_mycos3 = findViewById(R.id.img_mycos3);

         queue = Volley.newRequestQueue(getApplicationContext());

         //로그인 시 userid 출력
         Intent intent = getIntent();
         String id = intent.getExtras().getString("id");
//        String id=getIntent().getStringExtra("login_id");
         edt_main_id.setText(id+"님 환영합니다!");

         String listview_url = "http://220.71.97.208:8099/AndServer/CosListService";
         StringRequest request = new StringRequest(Request.Method.POST, listview_url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         Log.v("응답결과", response);
                         try {
                             JSONArray array = new JSONArray(response);
                             for(int i = 0; i <array.length(); i++){
                                 JSONObject jsonObject = array.getJSONObject(i);
                                 String u_cos_id = jsonObject.getString("u_cos_id");
                                 String cos_id = jsonObject.getString("cos_id");
                                 String u_cos_dead = jsonObject.getString("u_cos_dead");

                                 Log.v("응답결과", u_cos_id + "/" + cos_id + "/" + u_cos_dead);
                             }
                         } catch (JSONException e) {
                             e.printStackTrace();
                         }


                     }
                 },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         Log.v("오류", "요청실패");
                     }
                 }) {
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 Map<String, String> params = new HashMap<>();

                 params.put("id",id);

                 return params;
             }
         };
         queue.add(request);



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
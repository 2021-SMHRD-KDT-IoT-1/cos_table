package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    TextView tv_mycos,tv_usedate1,tv_usedate2,tv_usedate3,tv_usedcos;
    ImageButton img_mycos1, img_mycos2, img_mycos3;
    Button btn_plus;

    RequestQueue queue;


    private Object Context;

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

         // 사용 화장품 리스트 메소드 호출
         cos_uselist(id);


//         StringRequest request = new StringRequest(Request.Method.POST, listview_url,
//                 new Response.Listener<String>() {
//                     @Override
//                     public void onResponse(String response) {
//                         Log.v("response응답결과", response);
//
//                         try {
//                             JSONArray array = new JSONArray(response);
//                             //리스트뷰에 데이터 넣는 어뎁터
//                             ListV_cos = findViewById(R.id.ListV_cos);
//                             data = new ArrayList<>();
//                             for(int i = 0; i <array.length(); i++){
//                                 JSONObject jsonObject = array.getJSONObject(i);
//                                 String cos_name = jsonObject.getString("cos_name");
//                                 String cos_id = jsonObject.getString("cos_id");
//                                 String u_cos_dead = jsonObject.getString("u_cos_dead");
//
//                                 // 사용화장품의 사용기한 출력
//                                 tv_usedate1.setText(u_cos_dead);
//
//                                 data.add(new CoslistVO(cos_name, u_cos_dead, cos_id));
//
//                                 Log.v("응답결과", cos_id + "//" + u_cos_dead + "//" + cos_name);
//                             }
//                             adapter = new CoslistAdapter(getApplicationContext(),
//                                     R.layout.list_cositem,
//                                     data);
//                             ListV_cos.setAdapter(adapter);
//                         } catch (JSONException e) {
//                             e.printStackTrace();
//                         }
//                     }
//                 },
//                 new Response.ErrorListener() {
//                     @Override
//                     public void onErrorResponse(VolleyError error) {
//                         Log.v("오류", "요청실패");
//                     }
//                 }) {
//             @Override
//             protected Map<String, String> getParams() throws AuthFailureError {
//                 Map<String, String> params = new HashMap<>();
//
//                 params.put("id",id);
//
//                 return params;
//             }
//         };
//         queue.add(request);



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
                cos_info(id);
            }
        });
     }


     // 디비 연동 하는 코드를 메소드로 생성 후 필요할 떄 마다 불러서 사용
    
     public void cos_info(String id) {
         String LV_url = "http://121.147.0.224:8081/AndServer/CosListService";
         StringRequest request = new StringRequest(Request.Method.POST, LV_url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         Log.v("info응답결과", response);

                         try {
                             JSONArray array = new JSONArray(response);

                             for(int i = 0; i <array.length(); i++){
                                 JSONObject jsonObject = array.getJSONObject(i);
                                 String cos_name = jsonObject.getString("cos_name");
                                 String cos_id = jsonObject.getString("cos_id");
                                 String u_cos_dead = jsonObject.getString("u_cos_dead");

                                 Intent intent = new Intent(getApplicationContext(), Cos_IngredActivity.class);
                                 intent.putExtra("cos_id", cos_id);
                                 startActivity(intent);

                                 Log.v("응답결과", cos_name + "//" + cos_id + "//" + u_cos_dead);
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
     }

     public void cos_uselist(String id) {
         String LV2_url = "http://121.147.0.224:8081/AndServer/CosUseListService";
         StringRequest request = new StringRequest(Request.Method.POST, LV2_url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         Log.v("list응답결과", response);

                         try {
                             JSONArray array = new JSONArray(response);
                             //리스트뷰에 데이터 넣는 어뎁터
                             ListV_cos = findViewById(R.id.ListV_cos);
                             data = new ArrayList<>();
                             for(int i = 0; i <array.length(); i++){
                                 JSONObject jsonObject = array.getJSONObject(i);
                                 String cos_name = jsonObject.getString("cos_name");
                                 String u_cos_date = jsonObject.getString("u_cos_date");
                                 String state = jsonObject.getString("state");

                                 data.add(new CoslistVO(cos_name, u_cos_date, state));

                                 Log.v("응답결과", cos_name + "//" + u_cos_date + "//" + state);
                             }
                             adapter = new CoslistAdapter(getApplicationContext(),
                                     R.layout.list_cositem,
                                     data);
                             ListV_cos.setAdapter(adapter);
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

     }
  }
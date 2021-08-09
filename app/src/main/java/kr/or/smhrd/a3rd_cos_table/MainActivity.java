package kr.or.smhrd.a3rd_cos_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

    TextView tv_mycos,tv_usedcos;

    TextView[] arr_tv = new TextView[3];
    ImageButton[] arr_imgbtn = new ImageButton[3];


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
        tv_usedcos = findViewById(R.id.tv_usedcos);

        btn_plus = findViewById(R.id.btn_plus);


        queue = Volley.newRequestQueue(getApplicationContext());

        //로그인 시 userid 출력
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
//        String id=getIntent().getStringExtra("login_id");
        edt_main_id.setText(id + "님 환영합니다!");
        //---------------------------------------------------------------------------------------------------------
        // 사용중인 화장품 리스트 메소드 호출
//        JSONArray list_array = cos_list(id);
        String LV2_url = "http://220.71.97.208:8099/AndServer/CosListService";
        StringRequest request = new StringRequest(Request.Method.POST, LV2_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("사용중 응답: ", response);

                        try {
                            JSONArray list = new JSONArray(response);
                            for (int i = 0; i < list.length(); i++) {
                                JSONObject jsonObject = list.getJSONObject(i);

                                //db에서 받아온 값 변수에 저장
                                String cos_id = jsonObject.getString("cos_id");
                                String cos_name = jsonObject.getString("cos_name");
                                String u_cos_id = jsonObject.getString("u_cos_id");
                                String u_cos_dead = jsonObject.getString("u_cos_dead");

                                //---------------------------------------------------------------------------------------------------------
                                //초기화
                                int imgbtn = getResources().getIdentifier("img_mycos" + (i + 1), "id", getPackageName());
                                int tv_arr = getResources().getIdentifier("tv_usedate" + (i + 1), "id", getPackageName());
                                arr_imgbtn[i] = findViewById(imgbtn);
                                arr_tv[i] = findViewById(tv_arr);

                                //----------------------------------------------------------------------------------------------------------
                                //db에서 받아온 값으로 아이디 찾기
                                //사용중인 화장품 이미지, 사용기한 출력
                                int cos_num = getResources().getIdentifier("kr.or.smhrd.a3rd_cos_table:drawable/" + cos_id, null, null);

                                arr_imgbtn[i].setImageResource(cos_num);
                                arr_tv[i].setText(u_cos_dead);
                                //---------------------------------------------------------------------------------------------------------

                                //이미지 버튼에 클릭 이벤트 생성

                                arr_imgbtn[i].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), Cos_IngredActivity.class);
                                        intent.putExtra("cos_id", cos_id);
                                        startActivity(intent);
                                    }
                                });
                                //---------------------------------------------------------------------------------------------------------

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("사용중 오류 : ", "요청실패");
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id", id);

                return params;
            }
        };
        queue.add(request);
        //---------------------------------------------------------------------------------------------------------
        // 사용했던 화장품 리스트 메소드 호출
        cos_uselist(id);
        //---------------------------------------------------------------------------------------------------------
        //내 화장품 옆에 + 클릭시 화장품 등록 페이지로 이동
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        //---------------------------------------------------------------------------------------------------------
    }

     public void cos_uselist(String id) {
         String LV2_url = "http://220.71.97.208:8099/AndServer/CosUseListService";
         StringRequest request = new StringRequest(Request.Method.POST, LV2_url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         Log.v("사용했던 화장품 응답결과 : ", response);

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

                                 Log.v("사용했던 화장품 응답결과 : ", cos_name + "//" + u_cos_date + "//" + state);
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
                         Log.v("사용했던 화장품 오류 : ", "요청실패");
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
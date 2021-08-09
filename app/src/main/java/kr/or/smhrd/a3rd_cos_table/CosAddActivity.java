package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

import java.util.HashMap;
import java.util.Map;


public class CosAddActivity extends AppCompatActivity {

    Button btn_add;
    ImageView[] arr_img = new ImageView[3];
    TextView[] arr_amount = new TextView[3];
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_add);

        btn_add = findViewById(R.id.btn_add);


        queue = Volley.newRequestQueue(getApplicationContext());

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        // 등록 버튼 클릭 시 Cos_Shoot페이지로 이동
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CosAddActivity.this, Cos_ShootActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        String qrinfo_url = "http://220.71.97.208:8099/AndServer/CosAddInfoService";
        StringRequest request = new StringRequest(Request.Method.POST, qrinfo_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("qrinfo 응답결과 :",response);

                        try {
                            JSONArray infolist = new JSONArray(response);
                            for (int i = 0; i < infolist.length(); i++) {
                                JSONObject jsonObject = infolist.getJSONObject(i);

                                //db에서 받아온 값 변수에 저장
                                String cos_id = jsonObject.getString("cos_id");
                                String u_cos_id = jsonObject.getString("u_cos_id");
                                String amount = jsonObject.getString("amount");

                                //초기화
                                int arr_img_view = getResources().getIdentifier("img_add_"+(i+1), "id", getPackageName());
                                int arr_tv_amount = getResources().getIdentifier("tv_add_img"+(i+1), "id", getPackageName());

                                arr_img[i] = findViewById(arr_img_view);
                                arr_amount[i] = findViewById(arr_tv_amount);

                                //----------------------------------------------------------------------------------------------------------
                                //db에서 받아온 값으로 아이디 찾기
                                int cos_num = getResources().getIdentifier("kr.or.smhrd.a3rd_cos_table:drawable/"+cos_id, null, null);

                                arr_img[i].setImageResource(cos_num);
                                arr_amount[i].setText(amount);

                                arr_img[i].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), CosAddPopup.class);
                                        intent.putExtra("cos_id", cos_id);
                                        intent.putExtra("u_cos_id", u_cos_id);
                                        intent.putExtra("amount", amount);
                                        intent.putExtra("id", id);
                                        startActivity(intent);
                                    }
                                });


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("qrinfo 오류", "qrinfo 오류입니다.");

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id", id);

                return params;
            }
        };
        queue.add(request);


        //================================================================================================




    }
}
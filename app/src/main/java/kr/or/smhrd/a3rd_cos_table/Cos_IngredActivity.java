package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Cos_IngredActivity extends AppCompatActivity {

    TextView tv_detail_name, tv_detail_brand, tv_detail_type, tv_ing1, tv_ing2, tv_ing3, tv_ing4, tv_ing5;
    ImageView img_ingCos;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_ingred);

        tv_ing1 = findViewById(R.id.tv_ing1);
        tv_ing2 = findViewById(R.id.tv_ing2);
        tv_ing3 = findViewById(R.id.tv_ing3);
        tv_ing4 = findViewById(R.id.tv_ing4);
        tv_ing5 = findViewById(R.id.tv_ing5);
        tv_detail_name = findViewById(R.id.tv_detail_name);
        tv_detail_brand = findViewById(R.id.tv_detail_brand);
        tv_detail_type = findViewById(R.id.tv_detail_type);
        img_ingCos = findViewById(R.id.img_ingCos);


        queue = Volley.newRequestQueue(getApplicationContext());

        // main 페이지로부터 cos_id 값 받아오기
        Intent intent = getIntent();
        String cos_id = intent.getExtras().getString("cos_id");

        int cos_num = getResources().getIdentifier("kr.or.smhrd.a3rd_cos_table:drawable/"+cos_id,null, null);

        img_ingCos.setImageResource(cos_num);

        String detail_url = "http://59.0.236.194:8099/AndServer/CosDetailService";

        StringRequest request = new StringRequest(Request.Method.POST, detail_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("detailresponse응답결과", response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            String cos_name = jsonObject.getString("cos_name");
                            String cos_brand = jsonObject.getString("cos_brand");
                            String cos_type = jsonObject.getString("cos_type");
                            String igt1 = jsonObject.getString("igt1");
                            String igt2 = jsonObject.getString("igt2");
                            String igt3 = jsonObject.getString("igt3");
                            String igt4 = jsonObject.getString("igt4");
                            String igt5 = jsonObject.getString("igt5");

                            tv_detail_name.setText(cos_name);
                            tv_detail_brand.setText(cos_brand);
                            tv_detail_type.setText(cos_type);
                            tv_ing1.setText(igt1);
                            tv_ing2.setText(igt2);
                            tv_ing3.setText(igt3);
                            tv_ing4.setText(igt4);
                            tv_ing5.setText(igt5);


                            Log.v("igt응답결과", cos_name + "/" + cos_brand + "/" + cos_type + "/" + igt1 + "/" + igt2 + "/" + igt3 + "/" + igt4 + "/" + igt5);
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

                params.put("cos_id",cos_id);

                return params;
            }
        };
        queue.add(request);
    }
}
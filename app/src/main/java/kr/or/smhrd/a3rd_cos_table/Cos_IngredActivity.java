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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cos_IngredActivity extends AppCompatActivity {

    TextView tv_detail_name, tv_detail_brand, tv_detail_type, tv_Cos_Ingred;
    ImageView img_ingCos;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_ingred);

        tv_Cos_Ingred=findViewById(R.id.tv_Cos_Ingred);
        tv_detail_name = findViewById(R.id.tv_detail_name);
        tv_detail_brand = findViewById(R.id.tv_detail_brand);
        tv_detail_type = findViewById(R.id.tv_detail_type);
        img_ingCos = findViewById(R.id.img_ingCos);


        queue = Volley.newRequestQueue(getApplicationContext());

        Intent intent = getIntent();
        String cos_id = intent.getExtras().getString("cos_id");

//        if(cos_id.equals("cos_01")){
//            img_ingCos.setImageResource(R.drawable.cos_01);
//        }else if (cos_id.equals("cos_02")){
//            img_ingCos.setImageResource(R.drawable.cos_02);
//        }else if (cos_id.equals("cos_03")){
//            img_ingCos.setImageResource(R.drawable.cos_03);
//        }

        String detail_url = "http://220.71.97.208:8099/AndServer/CosDetailListService";

        StringRequest request = new StringRequest(Request.Method.POST, detail_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("detailresponse응답결과", response);

                        try {
                            JSONArray array = new JSONArray(response);

                            for(int i = 0; i <array.length(); i++){
                                JSONObject jsonObject = array.getJSONObject(i);
                                String cos_name = jsonObject.getString("cos_name");
                                String cos_brand = jsonObject.getString("cos_brand");
                                String cos_type = jsonObject.getString("cos_type");
                                String igt1 = jsonObject.getString("igt1");
                                String igt2 = jsonObject.getString("igt2");
                                String igt3 = jsonObject.getString("igt3");
                                String igt4 = jsonObject.getString("igt4");
                                String igt5 = jsonObject.getString("igt5");


                                Log.v("igt응답결과", cos_name + "//" + cos_brand + "//" + cos_type + "//" + igt1 + "//" + igt2 + "//" + igt3 + "//" + igt4 + "//" + igt5);
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

                params.put("cos_id",cos_id);

                return params;
            }
        };
        queue.add(request);
    }
}
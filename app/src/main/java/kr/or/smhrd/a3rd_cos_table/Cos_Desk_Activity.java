package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Cos_Desk_Activity extends AppCompatActivity {

    EditText edt_cos_table_id;
    Button btn_cos_table;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_desk);

        edt_cos_table_id = findViewById(R.id.edt_cos_table_id);
        btn_cos_table = findViewById(R.id.btn_cos_table);

        queue = Volley.newRequestQueue(getApplicationContext());

        btn_cos_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String table_id = edt_cos_table_id.getText().toString();
                Log.v("화장대아이디", table_id);

                String table_url = "http://220.71.97.208:8099/AndServer/CosAddDeskService";
                StringRequest request = new StringRequest(Request.Method.POST, table_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Log.v("응답결과", response);

                                if (response.equals("1")){
                                    Intent intent = new Intent(getApplicationContext(), cos_login.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(Cos_Desk_Activity.this, "실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.v("오류", "요청실패");

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();

                        params.put("table_id", table_id);

                        return params;
                    }
                };
                queue.add(request);

            }
        });
    }
}
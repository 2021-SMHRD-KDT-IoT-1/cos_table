package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public class CosDeletePopup extends AppCompatActivity {
    TextView tv_dmessage,tv_ucosid;
    Button btn_dcancle,btn_dcomplete,btn_dstop;

    RequestQueue queue;
    String state = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_delete_popup);

        tv_dmessage=findViewById(R.id.tv_dmessage);
        tv_ucosid=findViewById(R.id.tv_ucosid);
        btn_dcancle=findViewById(R.id.btn_dcancle);
        btn_dcomplete=findViewById(R.id.btn_dcomplete);
        btn_dstop=findViewById(R.id.btn_dstop);

        queue = Volley.newRequestQueue(getApplicationContext());
        Intent intent = new Intent();
        String u_cos_id = intent.getStringExtra("u_cos_id");
        tv_ucosid.setText(u_cos_id);



        //취소 버튼
        btn_dcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CosAddActivity.class);
                startActivity(intent);
            }
        });

        //완료 버튼 클릭 : 기존에 등록된 화장품 이미지와 정보 삭제&초기등록버튼으로 변경 / DB->state : complete로 update
        btn_dcomplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String u_cos_id=getText().toString();
                //String state=getText().toString();
                state="사용완료";

                String delete_url="http://59.0.236.194:8099/AndroidServer/CosDeleteService";

                //db에 state 전송
                StringRequest request=new StringRequest(Request.Method.POST, delete_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.v("응답결과",response);

                                if(response.equals("0")){
                                    Toast.makeText(CosDeletePopup.this, "삭제 실패..", Toast.LENGTH_SHORT).show();
                                    //실패시 다시 CosAddPopup 화면으로 이동
                                    Intent intent = new Intent(CosDeletePopup.this, CosAddPopup.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(CosDeletePopup.this, "삭제 성공!!", Toast.LENGTH_SHORT).show();
                                    //성공시 CosAddActivity로 이동
                                    Intent intent_delete = new Intent(getApplicationContext(), CosAddActivity.class);
                                    intent_delete.putExtra("imgCheck","gggg");
                                    //intent.putExtra("u_cos_id",u_cos_id);
                                    //intent.putExtra("state",state);

                                    startActivity(intent_delete);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("오류 결과","요청실패...");
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params=new HashMap<>();
                        params.put("u_cos_id",u_cos_id);
                        params.put("state",state);

                        return params;
                    }
                };

                queue.add(request);
            }
        }); //btn_complete 끝부분

        //중단 버튼 클릭 : 기존에 등록된 화장품 삭제&초기등록버튼으로 변경 / DB->state : stop로 update
        btn_dstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state="사용중단";

                String delete_url="http://59.0.236.194:8099/AndroidServer/CosDeleteService";

                //db에 state 전송
                StringRequest request=new StringRequest(Request.Method.POST, delete_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.v("응답결과",response);

                                if(response.equals("0")){
                                    Toast.makeText(CosDeletePopup.this, "삭제 실패..", Toast.LENGTH_SHORT).show();
                                    //실패시 다시 CosAddPopup 화면으로 이동
                                    Intent intent = new Intent(CosDeletePopup.this, CosAddPopup.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(CosDeletePopup.this, "삭제 성공!!", Toast.LENGTH_SHORT).show();
                                    //성공시 CosAddActivity로 이동
                                    Intent intent_delete = new Intent(getApplicationContext(), CosAddActivity.class);
                                    intent_delete.putExtra("imgCheck","gggg");
                                    //intent.putExtra("u_cos_id",u_cos_id);
                                    //intent.putExtra("state",state);

                                    startActivity(intent_delete);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("오류 결과","요청실패...");
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params=new HashMap<>();
                        params.put("u_cos_id",u_cos_id);
                        params.put("state",state);

                        return params;
                    }
                };

                queue.add(request);
            }

        });

    }
}
package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Cos_DetailActivity extends AppCompatActivity {
    TextView tv_name,tv_set, tv_dose, tv_brand, tv_type;
    ImageView img_detail_cos;
    Button btn_complete;
    RadioGroup amountGroup1, amountGroup2;
    RadioButton amount1, amount2, amount3, amount4, amount5, amount6;
    RequestQueue queue;

    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_detail);

        tv_name=findViewById(R.id.tv_name);
        tv_set=findViewById(R.id.tv_set);
        tv_dose=findViewById(R.id.tv_dose);
        tv_brand=findViewById(R.id.tv_brand);
        tv_type = findViewById(R.id.tv_type);

        img_detail_cos = findViewById(R.id.img_detail_cos);

        btn_complete = findViewById(R.id.btn_complete);

        amountGroup1 = findViewById(R.id.amountGroup1);
        amountGroup2 = findViewById(R.id.amountGroup2);
        amount1 = findViewById(R.id.amount1);
        amount2 = findViewById(R.id.amount2);
        amount3 = findViewById(R.id.amount3);
        amount4 = findViewById(R.id.amount4);
        amount5 = findViewById(R.id.amount5);
        amount6 = findViewById(R.id.amount6);

        queue = Volley.newRequestQueue(getApplicationContext());

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String scanResult = intent.getStringExtra("scanResult");

        String[] qrSplit=new String[4]; //qrScan??? -??? ???????????? ????????? ??????

        for (int i=0; i<qrSplit.length;i++) {
            qrSplit[i]= scanResult.split("-")[i]; //-??? ???????????? ????????? ??????
            Log.d("QRtest","test="+i+qrSplit[i]);
        }

        String cos_id = qrSplit[0];
        String cos_name = qrSplit[1];
        String cos_brand = qrSplit[2];
        String cos_type = qrSplit[3];

        Log.v("id : ", id);
        Log.v("scanResult : ", scanResult);
        Log.v("cos_id : ", cos_id);
        Log.v("cos_name : ", cos_name);
        Log.v("cos_type : ", cos_type);


        int cos_num = getResources().getIdentifier("kr.or.smhrd.a3rd_cos_table:drawable/" + cos_id, null, null);

        img_detail_cos.setImageResource(cos_num);
        tv_name.setText(cos_name);
        tv_brand.setText(cos_brand);
        tv_type.setText(cos_type);

        amountGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.amount1){
                    amountGroup2.setOnCheckedChangeListener(null);
                    amount = "0.5";
                }else if(checkedId==R.id.amount2){
                    amountGroup2.setOnCheckedChangeListener(null);
                    amount = "1.0";
                }else if(checkedId==R.id.amount3){
                    amountGroup2.setOnCheckedChangeListener(null);
                    amount = "1.5";
                }
            }
        });

        amountGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.amount4){
                    amountGroup1.setOnCheckedChangeListener(null);
                    amount = "2.0";
                }else if(checkedId==R.id.amount5){
                    amountGroup1.setOnCheckedChangeListener(null);
                    amount = "2.5";
                }else if(checkedId==R.id.amount6){
                    amountGroup1.setOnCheckedChangeListener(null);
                    amount = "3.0";
                }
            }
        });


        // ???????????? ?????? ?????? ??? ????????? ?????? ?????? cos_add ???????????? ??????
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://59.0.236.194:8099/AndServer/CosAddService";
                StringRequest request = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("1")){
                                    Intent intent = new Intent(getApplicationContext(), CosAddActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Cos_DetailActivity.this, "????????? ?????? ??????", Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("detailActivity ????????????", "??????");
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();

                        params.put("cos_id", cos_id);
                        params.put("id", id);
                        params.put("amount", amount);

                        return params;
                    }
                };
                queue.add(request);
            }
        });

        tv_dose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Cos_DetailActivity.this);
                dlg.setTitle("?????? ??? ??????"); //??????
                dlg.setMessage("?????? 0.5??????"  +"\n"+ "?????? 1??????" +"\n"+ "?????? 1.5??????"); // ?????????
//                ?????? ????????? ??????
                dlg.setPositiveButton("??????",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();
            }
        });

    }
}
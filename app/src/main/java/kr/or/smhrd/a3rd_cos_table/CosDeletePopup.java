package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CosDeletePopup extends AppCompatActivity {
    TextView tv_dmessage;
    Button btn_dcancle,btn_dcomplete,btn_dstop;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_delete_popup);

        tv_dmessage=findViewById(R.id.tv_dmessage);

        btn_dcancle=findViewById(R.id.btn_dcancle);
        btn_dcomplete=findViewById(R.id.btn_dcomplete);
        btn_dstop=findViewById(R.id.btn_dstop);

        queue = Volley.newRequestQueue(getApplicationContext());

        btn_dcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CosDeletePopup.this,CosAddActivity.class);
                startActivity(intent);
            }
        });

    }
}
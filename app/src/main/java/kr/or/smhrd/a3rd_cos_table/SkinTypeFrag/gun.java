package kr.or.smhrd.a3rd_cos_table.SkinTypeFrag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kr.or.smhrd.a3rd_cos_table.MembershipActivity;
import kr.or.smhrd.a3rd_cos_table.R;
import kr.or.smhrd.a3rd_cos_table.SkintestActivity;


public class gun extends Fragment {

    private ListView lv_gun;
    private ArrayAdapter<String> gun_adapter;
    private ArrayList<String> gun_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gun, container, false);
        Button btn_gun=view.findViewById(R.id.btn_gun);
        btn_gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), MembershipActivity.class);
                startActivity(intent);
            }
        });
        lv_gun=view.findViewById(R.id.lv_gun);
        gun_data=new ArrayList<>();
        gun_data.add("1.세안 후 얼굴이 전체적으로 당기며 건조하다.");
        gun_data.add("2.유분과 수분이 부족하여 피부가 거칠고 화장이 잘 안받는다.");
        gun_data.add("3.건조한 피부는 민감 피부가 되거나 노화가 빨리 진행되기 쉽다.");
        gun_data.add("4.모공이 작고 표정 주름이 쉽게 생기며 피부가 얇다.");
        gun_data.add("5.건조가 심해지면 눈 밑, 뺨, 턱입가의 피부가 늘어지고 얼굴에 잔주름이 늘어난다.");
        gun_data.add("6.피부와 땀 분비가 원활하지 않아 피부 보호막의 형성이 잘 되지 않으므로 수분이 쉽게 증발한다.");

        gun_adapter = new ArrayAdapter<String>(view.getContext().getApplicationContext(), android.R.layout.simple_list_item_1,gun_data);

        lv_gun.setAdapter(gun_adapter);
        lv_gun.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
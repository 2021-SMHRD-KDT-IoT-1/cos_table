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


public class jung extends Fragment {

    private ListView lv_jung;
    private ArrayAdapter<String> jung_adapter;
    private ArrayList<String> jung_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jung, container, false);
        Button btn_jung=view.findViewById(R.id.btn_jung);
        btn_jung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), MembershipActivity.class);
                startActivity(intent);
            }
        });
        lv_jung=view.findViewById(R.id.lv_jung);
        jung_data=new ArrayList<>();
        jung_data.add("1.피부에 건조하거나 유분이 많은 부분이 없다.");
        jung_data.add("2.약간의 유분기나 건조함이 간혹 생기지만 쉽게 없어진다.");
        jung_data.add("3.피부가 하루 종일 당기거나 건조하지 않다. 너무 반짝거리지도 않는다.");
        jung_data.add("4.피부 톤이 균일하다.");
        jung_data.add("5.건조가 심해지면 눈 밑, 뺨, 턱입가의 피부가 늘어지고 얼굴에 잔주름이 늘어난다.");

        jung_adapter = new ArrayAdapter<String>(view.getContext().getApplicationContext(), android.R.layout.simple_list_item_1,jung_data);

        lv_jung.setAdapter(jung_adapter);
        lv_jung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
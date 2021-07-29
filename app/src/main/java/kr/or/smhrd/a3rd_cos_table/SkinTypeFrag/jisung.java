package kr.or.smhrd.a3rd_cos_table.SkinTypeFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import kr.or.smhrd.a3rd_cos_table.MembershipActivity;
import kr.or.smhrd.a3rd_cos_table.R;
import kr.or.smhrd.a3rd_cos_table.SkintestActivity;


public class jisung extends Fragment {

    private ListView lv_jisung;
    private ArrayAdapter<String> jinsung_adapter;
    private ArrayList<String> jinsung_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jisung, container, false);
        Button btn_jisung=view.findViewById(R.id.btn_jisung);
        btn_jisung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), MembershipActivity.class);
                startActivity(intent);
            }
        });
        lv_jisung=view.findViewById(R.id.lv_jisung);
        jinsung_data=new ArrayList<>();
        jinsung_data.add("1.화장하고 시간이 얼마 지나지 않아 번들거리며 잘 지워진다.");
        jinsung_data.add("2.과다한 피지가 피부 표면을 덮고 있어 얼굴색이 어둡고 칙칙하다.");
        jinsung_data.add("3.피부의 각질층의 두껍고 귤 껍질처럼 흉터 자국들이 움푹 패어져있다.");
        jinsung_data.add("4.피지분비 과다로 여드름이나 뾰루지 같은 트러블이 자주 발생한다.");
        jinsung_data.add("5.모공이 넓고 블랙헤드가 많은편이다.");
        jinsung_data.add("6.모발에 기름기가 많으며 비듬과 귀지가 많은 편이다.");

        jinsung_adapter = new ArrayAdapter<String>(view.getContext().getApplicationContext(), android.R.layout.simple_list_item_1,jinsung_data);

        lv_jisung.setAdapter(jinsung_adapter);
        lv_jisung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
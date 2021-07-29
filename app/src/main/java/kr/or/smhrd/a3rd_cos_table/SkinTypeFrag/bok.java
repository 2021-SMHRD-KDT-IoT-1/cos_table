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


public class bok extends Fragment {

    private ListView lv_bok;
    private ArrayAdapter<String> bok_adapter;
    private ArrayList<String> bok_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bok, container, false);
        Button btn_bok=view.findViewById(R.id.btn_bok);
        btn_bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), MembershipActivity.class);
                startActivity(intent);
            }
        });
        lv_bok=view.findViewById(R.id.lv_bok);
        bok_data=new ArrayList<>();
        bok_data.add("1.콧방울에 블랙헤드가 눈에 띈다.");
        bok_data.add("2.T존 부위(이마, 코)는 번들거리며 U존 부위(볼, 입가, 눈가)는 건조한 피부상태가 눈에 띄게 차이난다.");
        bok_data.add("3.세안한 뒤 눈 주위, 광대뼈, 볼 주위가 속당김이 심하다.");
        bok_data.add("4.피부결이 거칠며 환절기에 얼굴이 더욱 당기는 느낌이 있다.");
        bok_data.add("5.이마와 코 부위에 기름기가 많고 여드름이 쉽게 생긴다.");

        bok_adapter = new ArrayAdapter<String>(view.getContext().getApplicationContext(), android.R.layout.simple_list_item_1,bok_data);

        lv_bok.setAdapter(bok_adapter);
        lv_bok.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
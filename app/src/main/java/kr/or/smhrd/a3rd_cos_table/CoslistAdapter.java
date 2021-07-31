package kr.or.smhrd.a3rd_cos_table;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class CoslistAdapter extends BaseAdapter {

    private Context context;// 현재 Activity의 정보
    private int layout; // listview에 보여질 아이템 레이아웃
    private ArrayList<CoslistVO> data; // 아이템 레이아웃에 출력할 데이터셋
    private LayoutInflater inflater; //inflater : xml파일을 view 형태로 변환하는 역할, 반드시 필요
    private ViewHolder holder;

    public CoslistAdapter(Context context, int layout, ArrayList<CoslistVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(layout, parent, false);
            //ViewHolder 패턴 적용
            // -findViewById()는 xml에 배치된 view의 id를 찾는 메소드로
            // listView의 성능을 저하시킬 수 있는 요인
            // - ViewHolder 객체 생성시 findViewById()는 한번만 실행
            holder=new ViewHolder(convertView);
        }

//            //List_cositem.xml 안에 있는 View 중에서 id가 img_list_cos인 ImageView정보를 접근
//            ImageView img_list_cos=convertView.findViewById(R.id.img_list_cos);
//            TextView tv_list_cosname=convertView.findViewById(R.id.tv_list_cosname);
//            TextView tv_list_date=convertView.findViewById(R.id.tv_list_date);

            CoslistVO vo=data.get(position);

            holder.tv_list_cosname.setText(vo.getName());
            holder.tv_list_date.setText(vo.getDate());
            holder.tv_result.setText(vo.getResult());

            return convertView;
        }


}

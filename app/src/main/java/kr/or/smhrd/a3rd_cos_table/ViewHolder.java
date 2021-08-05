package kr.or.smhrd.a3rd_cos_table;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {

    TextView tv_list_cosname;
    TextView tv_list_date;
    TextView tv_result;

      public ViewHolder(View itemView){
        tv_list_cosname = itemView.findViewById(R.id.tv_list_cosname);
        tv_list_date = itemView.findViewById(R.id.tv_list_date);
        tv_result = itemView.findViewById(R.id.tv_state);

    }


}

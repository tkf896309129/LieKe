package com.comexample.lieke.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.bean.TeamListBean;
import com.comexample.lieke.myapplication.utils.PicassoUtils;
import com.comexample.lieke.myapplication.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class TeamAdapter extends BaseAbstractAdapter<TeamListBean> {
    public TeamAdapter(Context context, List<TeamListBean> list) {
        super(context, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder == null) {
            convertView = inflater.inflate(R.layout.item_team_member, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PicassoUtils.loadImage(context, list.get(position).getHeadPic(), holder.imgHead);
//        holder.tvContent.setText(list.get(position).getSortdisplay());
        holder.tvName.setText(list.get(position).getRealname());
        holder.tvState.setText(list.get(position).getToLastLine());
        holder.tvTime.setText(list.get(position).getCreatetime());
        if (StringUtils.isNoEmpty(list.get(position).getSortno())) {
            holder.tvState.setText(list.get(position).getSortno());
        }

//        holder.tvName.setText("哈哈");
        return convertView;
    }


    class ViewHolder {
        ImageView imgHead;
        TextView tvName;
        TextView tvState;
        TextView tvTime;
        TextView tvContent;
        TextView tvSort;

        public ViewHolder(View convetView) {
            imgHead = (ImageView) convetView.findViewById(R.id.iv_team_head);
            tvName = (TextView) convetView.findViewById(R.id.tv_team_name);
            tvState = (TextView) convetView.findViewById(R.id.tv_team_state);
            tvTime = (TextView) convetView.findViewById(R.id.tv_team_time);
            tvContent = (TextView) convetView.findViewById(R.id.tv_team_context);
            tvSort = (TextView) convetView.findViewById(R.id.tv_team_sort);
        }

    }
}

package com.comexample.lieke.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.bean.ProductListBean;
import com.comexample.lieke.myapplication.utils.PicassoUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class OrderProAdapter extends BaseAbstractAdapter<ProductListBean> {
    public OrderProAdapter(Context context, List<ProductListBean> list) {
        super(context, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder == null) {
            convertView = inflater.inflate(R.layout.item_order_goodsdetails, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PicassoUtils.loadCircleImage(context, list.get(position).getPic(), holder.imgHead);
        holder.tvNum.setText("x" + list.get(position).getToNum());
        holder.tvPrice.setText("￥" + list.get(position).getToPrice());
        holder.tvName.setText(list.get(position).getName());
        return convertView;
    }


    class ViewHolder {
        ImageView imgHead;
        TextView tvName;
        TextView tvPrice;
        TextView tvNum;

        public ViewHolder(View convertView) {
            imgHead = (ImageView) convertView.findViewById(R.id.iv_goods_details);
            tvName = (TextView) convertView.findViewById(R.id.tv_goods_name);
            tvPrice = (TextView) convertView.findViewById(R.id.tv_goods_price);
            tvNum = (TextView) convertView.findViewById(R.id.tv_goods_num);
        }
    }


}

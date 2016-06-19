package com.comexample.lieke.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.bean.HomeOrderListBean;
import com.comexample.lieke.myapplication.bean.MainOrderReobjBean;
import com.comexample.lieke.myapplication.bean.ProductListBean;
import com.comexample.lieke.myapplication.utils.PicassoUtils;
import com.comexample.lieke.myapplication.utils.StringUtils;
import com.comexample.lieke.myapplication.view.OrderListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaifeng on 2016/6/15.
 */
public class OrderMainAdapter extends BaseAbstractAdapter<HomeOrderListBean> {
    public OrderMainAdapter(Context context, List<HomeOrderListBean> list) {
        super(context, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder == null) {
            convertView = inflater.inflate(R.layout.item_order_details, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //主部分
        PicassoUtils.loadImage(context, list.get(position).getBusinessPic(), holder.imgUserHead);
        holder.tvUserName.setText(list.get(position).getBuyerRealname());
        holder.tvOrderId.setText("订单号：" + list.get(position).getOrderID());
        holder.tvNameBuy.setText(list.get(position).getBuyerRealname() + "购买了：");

        //商品部分
        holder.tvAllPrice.setText("￥" + list.get(position).getOrderPrice());
        OrderProAdapter adapter = new OrderProAdapter(context, list.get(position).getProductList());
        holder.orderListView.setDividerHeight(0);
        holder.orderListView.setAdapter(adapter);


        //成员部分
        //客服
        if (StringUtils.isNoEmpty(list.get(position).getFuwuHeadPic())) {
            PicassoUtils.loadCircleImage(context, list.get(position).getFuwuHeadPic(), holder.imgKeFu);
            holder.tvKeFu.setText("官方客服");
        }
        if (StringUtils.isNoEmpty(list.get(position).getFuwuTimes())) {
            holder.tvKeFuTimes.setText(list.get(position).getFuwuTimes());
        }
        //父级猎人
        if (StringUtils.isNoEmpty(list.get(position).getFatherHeadPic())) {
            PicassoUtils.loadCircleImage(context, list.get(position).getFatherHeadPic(), holder.imgFather);
            holder.tvFather.setText("父级猎人");
        }
        if (StringUtils.isNoEmpty(list.get(position).getFatherTimes())) {
            holder.tvFatherTimes.setText(list.get(position).getFatherTimes());
        }

        //用户
        if (StringUtils.isNoEmpty(list.get(position).getBuyerHeadPic())) {
            PicassoUtils.loadCircleImage(context, list.get(position).getBuyerHeadPic(), holder.imgMine);
            holder.tvMine.setText(list.get(position).getBusinessName());
            holder.tvMineTimes.setText(list.get(position).getMyTimes());
        }


        //核销码
        if (StringUtils.isNoEmpty(list.get(position).getOrderStatePic())) {
            PicassoUtils.loadImage(context, list.get(position).getOrderStatePic(), holder.imgCode);
        }
        if (StringUtils.isNoEmpty(list.get(position).getOrderState())) {
            holder.tvCodeText.setText(list.get(position).getOrderState());
        }
        holder.tvCodeName.setText(list.get(position).getBusinessName());
        holder.tvPhoneNum.setText("位置：" + list.get(position).getBusinessAddress());


        //状态
//        PicassoUtils.loadImage(context,list.get(position).get);
        return convertView;
    }


    class ViewHolder {
        //主要部分
        ImageView imgUserHead;
        TextView tvUserName;
        TextView tvOrderId;
        TextView tvNameBuy;

        //商品部分
        OrderListView orderListView;
        TextView tvAllPrice;
        TextView tvTimeAgo;

        //成员部分
        //客服
        ImageView imgKeFu;
        TextView tvKeFu;
        TextView tvKeFuTimes;

        //父级猎人
        ImageView imgFather;
        TextView tvFather;
        TextView tvFatherTimes;

        //用户
        ImageView imgMine;
        TextView tvMine;
        TextView tvMineTimes;

        ImageView imgChat;

        //验证码
        ImageView imgCode;
        TextView tvCodeName;
        TextView tvPhoneNum;
        TextView tvCodeText;

        //状态
        ImageView imgState;


        public ViewHolder(View convertView) {
            imgUserHead = (ImageView) convertView.findViewById(R.id.img_user_head);
            tvUserName = (TextView) convertView.findViewById(R.id.tv_name);
            tvOrderId = (TextView) convertView.findViewById(R.id.tv_order_id);
            tvNameBuy = (TextView) convertView.findViewById(R.id.tv_name_buy);

            orderListView = (OrderListView) convertView.findViewById(R.id.lv_order_goods);
            tvAllPrice = (TextView) convertView.findViewById(R.id.tv_all_price);
            tvTimeAgo = (TextView) convertView.findViewById(R.id.tv_time_ago);

            imgKeFu = (ImageView) convertView.findViewById(R.id.iv_kefu_details);
            tvKeFu = (TextView) convertView.findViewById(R.id.tv_kefu_name);
            tvKeFuTimes = (TextView) convertView.findViewById(R.id.tv_kefu_times);

            imgFather = (ImageView) convertView.findViewById(R.id.iv_father_details);
            tvFather = (TextView) convertView.findViewById(R.id.tv_father_name);
            tvFatherTimes = (TextView) convertView.findViewById(R.id.tv_father_times);

            imgMine = (ImageView) convertView.findViewById(R.id.iv_mine_details);
            tvMine = (TextView) convertView.findViewById(R.id.tv_mine_name);
            tvMineTimes = (TextView) convertView.findViewById(R.id.tv_mine_times);

            imgChat = (ImageView) convertView.findViewById(R.id.iv_chat);

            imgCode = (ImageView) convertView.findViewById(R.id.iv_code);
            tvCodeName = (TextView) convertView.findViewById(R.id.tv_code_name);
            tvPhoneNum = (TextView) convertView.findViewById(R.id.tv_code_phoe);
            tvCodeText = (TextView) convertView.findViewById(R.id.tv_code_text);

            imgState = (ImageView) convertView.findViewById(R.id.iv_order_state);
        }

    }
}

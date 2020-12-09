package com.example.lastclassdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lastclassdemo.R;
import com.example.lastclassdemo.bean.TypeBean;

import java.util.List;

/**
 * @author SpreadWater
 * @Date 2020-12-09
 * @Time 11:25
 * @description
 */
public class TypeBaseAdapter extends BaseAdapter {
    Context context;
    List<TypeBean>mDatas;
    int selectPos=0;//本次点击的位置
    public TypeBaseAdapter(Context context, List<TypeBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.item_recordfrag_gv,viewGroup,false);
        //查找布局当中控件
        ImageView iv=view.findViewById(R.id.item_recordfrag_iv);
        TextView tv=view.findViewById(R.id.item_recordfrag_tv);
        //获取指定位置的数据源
        TypeBean typeBean=mDatas.get(i);
        tv.setText(typeBean.getTypename());
        //判断当前位置是否被点击
        if (selectPos==i){
            iv.setImageResource(typeBean.getSimageId());
        }else{
            iv.setImageResource(typeBean.getImageId());
        }
        return view;
    }
    //这个适配器不考虑复用问题，因为所有的item都显示在界面上，不会因为滑动就消失，没有多余的convertview，所以不用腹泻
}

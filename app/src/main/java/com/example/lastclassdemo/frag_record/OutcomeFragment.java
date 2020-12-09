package com.example.lastclassdemo.frag_record;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lastclassdemo.R;
import com.example.lastclassdemo.adapter.TypeBaseAdapter;
import com.example.lastclassdemo.bean.DBManager;
import com.example.lastclassdemo.bean.TypeBean;
import com.example.lastclassdemo.utils.KeyBoardUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *记录支出模块的支出部分
 */
public class OutcomeFragment extends Fragment {

    KeyboardView keyboardView;
    EditText monyEt;
    ImageView typeIv;
    TextView typeTv,beizhuTv,timeTv;
    GridView typeGv;
    List<TypeBean>typeList;
    TypeBaseAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_outcome,container,false);
        initView(view);
        //给gridview填充数据
        loadDataToGv();
        return view;
    }

    private void loadDataToGv() {
        typeList=new ArrayList<>();
        adapter=new TypeBaseAdapter(getContext(),typeList);
        typeGv.setAdapter(adapter);
        //获取数据库当中的数据源
       List<TypeBean>outlist= DBManager.getTypeList(0);
       typeList.addAll(outlist);
       adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        keyboardView=view.findViewById(R.id.frag_record_keyborad);
        monyEt=view.findViewById(R.id.frag_record_et_money);
        typeIv=view.findViewById(R.id.frag_record_iv);
        typeGv=view.findViewById(R.id.frag_record_record_gv);
        typeTv=view.findViewById(R.id.frag_record_tv_type);
        beizhuTv=view.findViewById(R.id.frag_record_tv_beizhu);
        timeTv=view.findViewById(R.id.frag_record_tv_time);
        //显示自定义软键盘
        KeyBoardUtils boardUtils=new KeyBoardUtils(keyboardView,monyEt);
        boardUtils.showKeyboard();
        //设置接口监听确定按钮
        boardUtils.setOnEnsureListener(new KeyBoardUtils.OnEnsureListener() {
            @Override
            public void onEnsure() {
                //TODO 获取记录的信息，返回上一级
            }
        });

    }
}
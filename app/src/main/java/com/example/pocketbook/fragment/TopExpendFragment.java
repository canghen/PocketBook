package com.example.pocketbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketbook.Adapter.ExpendIconAdapter;
import com.example.pocketbook.R;
import com.example.pocketbook.model.Icon;

import java.util.ArrayList;
import java.util.List;


public class TopExpendFragment extends Fragment {

    private static final String TAG = "TopExpendFragment";
    private List<Icon> mExpendIconList = new ArrayList<>();
    private ExpendIconAdapter mExpendIconAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //注意此处的view与下面加载RecyclerView的view为同一个，否则报空指针异常！
        view = inflater.inflate(R.layout.fragment_top_expend, container, false);
        Log.d(TAG,"onCreateView");
        initIcons();
        initEvents();
        return view;
    }

    /**
     * 初始化Icon数据
     */
    private void initIcons() {
        Icon daily = new Icon("日用", R.drawable.daily);
        Icon restaurant = new Icon("餐饮", R.drawable.restaurant);
        Icon shopping = new Icon("购物", R.drawable.shopping);
        Icon study = new Icon("学习", R.drawable.study);
        Icon traffic = new Icon("交通", R.drawable.traffic);
        mExpendIconList.add(daily);
        mExpendIconList.add(restaurant);
        mExpendIconList.add(shopping);
        mExpendIconList.add(study);
        mExpendIconList.add(traffic);
    }

    /**
     * 创建LayoutManager对象设置到RecyclerView实例中，LayoutManger指定布局方式
     * 将Icon数据传入到Adapter的实例中，setAdapter完成适配器的设置
     */
    private void initEvents() {
        //获取recyclerView
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.expend_view);
        //创建adapter
        mExpendIconAdapter = new ExpendIconAdapter(mExpendIconList);
        //设置Adapter
        mRecyclerView.setAdapter(mExpendIconAdapter);
        //创建Layout布局对象，这里使用Grid布局
        //参数是：上下文，3列
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(layoutManager);
        Log.d(TAG,"initEvents");
    }
}



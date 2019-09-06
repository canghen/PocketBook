package com.example.pocketbook.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketbook.R;
import com.example.pocketbook.model.Icon;

import java.util.List;

public class ExpendIconAdapter extends RecyclerView.Adapter<ExpendIconAdapter.ViewHolder> {

    private List<Icon> mExpendIconList;

    /**
     * 定义内部类ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView iconName;

        public ViewHolder(@NonNull View view) { //view为recycler子项的最外层布局，然后获取实例
            super(view);
            iconImage = (ImageView) view.findViewById(R.id.icon_image);
            iconName = (TextView) view.findViewById(R.id.icon_name);
        }
    }

    /**
     * 构造函数，传进数据源，赋值给全局变量
     *
     * @param expendIconList
     */
    public ExpendIconAdapter(List<Icon> expendIconList) {
        mExpendIconList = expendIconList;
    }

    /**
     * 重写三个方法
     */
    @NonNull
    @Override
    //加载icon_item布局，创建ViewHolder实例，布局传入构造函数，返回实例
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //对Recycler子项进行赋值，通过position得到实例，将数据设置到ViewHolder的ImageView和TextView（数据和控件绑定）
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Icon expendIcon = mExpendIconList.get(position);
        holder.iconImage.setImageResource(expendIcon.getIconImage());
        holder.iconName.setText(expendIcon.getIconName());
    }

    //用于告诉RecyclerView有多少子项，返回数据源长度
    @Override
    public int getItemCount() {
        return mExpendIconList.size();
    }
}

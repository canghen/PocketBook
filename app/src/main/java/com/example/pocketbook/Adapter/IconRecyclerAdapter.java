package com.example.pocketbook.Adapter;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketbook.R;

import java.util.List;

public class IconRecyclerAdapter extends RecyclerView.Adapter<IconRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<Icon> mIconList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView sCardView;
        ImageView sIconImage;
        TextView sIconName;

        public ViewHolder(@NonNull View view) {
            super(view);
            sCardView = (CardView) view;
            sIconImage = (ImageView) view.findViewById(R.id.icon_image);
            sIconName = (TextView) view.findViewById(R.id.icon_name);
        }
    }

    public IconRecyclerAdapter(List<Icon> iconList) {
        mIconList = iconList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}

package com.example.pocketbook.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketbook.model.Icon;
import java.util.List;

public class IcomeIconAdapter extends RecyclerView.Adapter<IcomeIconAdapter.ViewHolder> {

    private List<Icon> mIcomeList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView iconName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public IcomeIconAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IcomeIconAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

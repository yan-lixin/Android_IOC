package com.ioc.library.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/3/25
 * Description:
 */
public abstract class RviewAdapter<T> extends RecyclerView.Adapter<RViewHolder> {

    private RView.OnItemClickListener onItemClickListener; //条目单击事件监听
    private RView.OnItemLongClickListener onItemLongClickListener; //条目长按事件监听
    private List<T> datas;

    public RviewAdapter(List<T> datas) {
        if (datas == null) {
            this.datas = new ArrayList<>();
            return;
        }
        this.datas = datas;
    }

    public void setOnItemClickListener(RView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(RView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public abstract int getLayoutId();

    public abstract void convert(RViewHolder holder, T t);

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layoutId = getLayoutId();
        RViewHolder holder = RViewHolder.createViewHolder(viewGroup.getContext(), viewGroup, layoutId);
        setListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int i) {
        convert(holder, datas.get(i));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private void setListener(final RViewHolder holder) {
        if (holder == null) {
            return;
        }
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != -1) {
                        onItemClickListener.onItemClick(v, datas.get(position), position);
                    }
                }
            }
        });

        holder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null) {
                    int position = holder.getAdapterPosition();
                    return onItemLongClickListener.onItemLongClick(v, datas.get(position), position);
                }
                return false;
            }
        });
    }
}

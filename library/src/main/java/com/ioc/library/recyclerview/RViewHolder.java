package com.ioc.library.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/3/25
 * Description:
 */
public class RViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews; //View控件集合
    private View mConvertView; //当前View

    public RViewHolder(@NonNull View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    /**
     * 创建RecyclerViewHolder对象
     * @param context
     * @param parent
     * @param layoutId
     * @return
     */
    static RViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RViewHolder(itemView);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    View getConvertView() {
        return mConvertView;
    }
}

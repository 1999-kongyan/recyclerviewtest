package com.example.recyclerviewtest;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public abstract class SwipeCardAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List mList;

    public SwipeCardAdapter(List list) {
        mList = list;
    }

    /**
     * 删除最顶部Item
     * 当只剩最后一张时，不会删除
     */

    public void delTopItem() {
        int position = getItemCount() - 1;
        if(position > 1) {
            mList.remove(position);
            notifyItemRemoved(position);
        }else{
            Log.d("DEL","最后一张了");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

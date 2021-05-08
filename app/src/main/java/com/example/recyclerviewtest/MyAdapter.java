package com.example.recyclerviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
import java.util.Random;

/**
 * @author zmy
 * create at $ $
 * @Params :$
 */
public class MyAdapter extends SwipeCardAdapter<MyAdapter.MyHolder> {
    private Context mContext;

    public MyAdapter(Context context, List<String> list) {
        super(list);
        mContext = context;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.setData((String) mList.get(position));
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;
        private Button mButton;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mButton = (Button) itemView.findViewById(R.id.button);

        }

        public void setData(String text) {
            mTextView.setText("这是第"+text+"个");

            int i = ((int)(10 * Math.random())) % 2;
            if(i == 0) {
                mImageView.setImageResource(R.drawable.test_big_picture);
            }else  mImageView.setImageResource(R.drawable.backgd);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"Button"+text+"被点击了",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

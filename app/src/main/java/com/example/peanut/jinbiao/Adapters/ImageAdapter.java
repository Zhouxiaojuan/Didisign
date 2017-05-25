package com.example.peanut.jinbiao.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.peanut.jinbiao.Activity.ImageRoom;
import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Images;

import java.util.List;

/**
 * Created by Peanut on 2017/5/12.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;

    private List<Images> mImagelist;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Images images=mImagelist.get(position);
                Intent intent=new Intent(context,ImageRoom.class);
                intent.putExtra(ImageRoom.IMAGE_NUM,images.getNum());
                intent.putExtra(ImageRoom.IMAGE_ID,images.getImgID());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Images image=mImagelist.get(position);
        holder.imageView.setImageResource(image.getImgID());
        holder.textView.setText(image.getNum());
    }

    @Override
    public int getItemCount() {
        return mImagelist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            imageView= (ImageView) itemView.findViewById(R.id.image_main);
            textView= (TextView) itemView.findViewById(R.id.image_num);
        }
    }

    public ImageAdapter(List<Images> touxiangList){
        mImagelist=touxiangList;
    }

    public List<Images> getImageList(){
        return mImagelist;
    }
}

package com.example.peanut.jinbiao.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peanut.jinbiao.R;
import com.example.peanut.jinbiao.test.Sign;

import java.util.List;

/**
 * Created by Peanut on 2017/5/12.
 */

public class SignAdapter extends RecyclerView.Adapter<SignAdapter.ViewHolder> {

    private Context context;

    private List<Sign> textlist;

    public SignAdapter(List<Sign> list){textlist=list;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.sign_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion=holder.getAdapterPosition();
                Sign sign=textlist.get(postion);
                Toast.makeText(v.getContext(),"You click "+sign.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sign sign=textlist.get(position);
        holder.textview.setText(sign.getText());
    }

    @Override
    public int getItemCount() {
        return textlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            textview= (TextView) itemView.findViewById(R.id.imageroom_sign);
        }
    }
}

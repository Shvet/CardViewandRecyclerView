package com.shvet.cardviewandrecyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shvet on 10/10/2015,CardView and RecyclerView
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<String> strings;

    /**
     * public Constructor
     */
    public MyRecyclerViewAdapter(Context context, ArrayList<String> arrayList) {

        this.context = context;
        this.strings = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setTag(position);
        holder.cardView.setTag(position);

        holder.textView.setText(strings.get(position));

        if (position % 2 == 0) {
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.colorzero, null));
        } else {
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.colorone, null));
        }

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}

package com.siddharthsinghbaghel.healthyways.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.siddharthsinghbaghel.healthyways.R;
import com.siddharthsinghbaghel.healthyways.pojo.Item;

import java.util.ArrayList;

public class api_recycler_adapter extends RecyclerView.Adapter<api_recycler_adapter.api_recycler_viewHolder> {

        private final ArrayList<Item> itemList;
        private final Context context;

    public api_recycler_adapter(ArrayList<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public api_recycler_adapter.api_recycler_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new api_recycler_viewHolder(

                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycler_view_item, parent, false
                )

        );    }

    @Override
    public void onBindViewHolder(@NonNull api_recycler_adapter.api_recycler_viewHolder holder, int position) {
        holder.setTextView(itemList.get(position));
        holder.onClickTextView(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class api_recycler_viewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView description;
        private CardView cardView;
        public api_recycler_viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textViewAdapter);
            description = itemView.findViewById(R.id.description);
            cardView = itemView.findViewById(R.id.card_view);

        }

        void setTextView(Item item){
            textView.setText(item.getIssue().getName());
        }

        void onClickTextView(Item item){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (textView.getTypeface() != Typeface.DEFAULT_BOLD) {
                        textView.setTypeface(Typeface.DEFAULT_BOLD);
                        description.setVisibility(View.VISIBLE);
                        description.setText(item.getIssue().getIcdName());
                    } else{
                        textView.setTypeface(Typeface.DEFAULT);
                        description.setVisibility(View.GONE);
                    }
                }
            });

        }
    }
}

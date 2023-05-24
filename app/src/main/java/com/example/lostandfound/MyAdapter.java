package com.example.lostandfound;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context context;
    private ArrayList Type_id,Name_id;

    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, ArrayList type_id, ArrayList name_id) {
        this.context = context;
        Type_id = type_id;
        Name_id = name_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Type_id.setText(String.valueOf(Type_id.get(position)));
        holder.Name_id.setText(String.valueOf(Name_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return Name_id.size();
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Type_id,Name_id;
        Button mybutton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Type_id=itemView.findViewById(R.id.textPost);
            Name_id=itemView.findViewById(R.id.textName);
            mybutton=itemView.findViewById(R.id.ViewButton);

            mybutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}

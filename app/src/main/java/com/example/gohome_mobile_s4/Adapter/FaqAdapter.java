package com.example.gohome_mobile_s4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gohome_mobile_s4.Model.FaqModel;
import com.example.gohome_mobile_s4.R;


import java.util.ArrayList;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder>{
    ArrayList<FaqModel> arrayList;
    Context context;

    public FaqAdapter(ArrayList<FaqModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public FaqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faq_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.ViewHolder holder, int position) {
        holder.judul_faq.setText(arrayList.get(position).judul);
        holder.deskripsi_faq.setText(arrayList.get(position).deskripsi);
        holder.judul_faq.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (arrayList.get(pos).isVisible) {
                    holder.deskripsi_faq.setVisibility(View.GONE);
                    holder.deskripsi_line.setVisibility(View.GONE);
                    holder.judul_line.setVisibility(View.VISIBLE);
                    arrayList.get(pos).isVisible=false;
                }else {
                    holder.deskripsi_faq.setVisibility(View.VISIBLE);
                    holder.deskripsi_line.setVisibility(View.VISIBLE);
                    holder.judul_line.setVisibility(View.GONE);
                    arrayList.get(pos).isVisible=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul_faq, deskripsi_faq;
        RelativeLayout judul_line, deskripsi_line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul_faq = itemView.findViewById(R.id.judul_faq);
            deskripsi_faq = itemView.findViewById(R.id.deskripsi_faq);
            judul_line = itemView.findViewById(R.id.judul_line);
            deskripsi_line = itemView.findViewById(R.id.deskripsi_line);
        }
    }
}

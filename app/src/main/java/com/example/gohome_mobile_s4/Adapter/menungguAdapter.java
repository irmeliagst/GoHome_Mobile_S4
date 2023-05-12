package com.example.gohome_mobile_s4.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gohome_mobile_s4.Model.MenungguModel;
import com.example.gohome_mobile_s4.R;

import java.util.List;

public class menungguAdapter extends RecyclerView.Adapter <menungguAdapter.Viewholder>{
    private List<MenungguModel> MenungguModelList;

    public menungguAdapter(Context context, List<MenungguModel>MenungguModelList){
        this.MenungguModelList = MenungguModelList;
    }
    @NonNull
    @Override
    public menungguAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaksi_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menungguAdapter.Viewholder holder, int position) {
        holder.jenis_kamar.setText(MenungguModelList.get(position).getJenis_kamar());
        holder.total.setText(MenungguModelList.get(position).getTotal());
        holder.status.setText(MenungguModelList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        if (MenungguModelList != null) {
            return MenungguModelList.size();
        }
        return 0;
    }
    public  class  Viewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView jenis_kamar;
        private TextView total;
        private TextView status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            jenis_kamar = itemView.findViewById(R.id.textview);
            total = itemView.findViewById(R.id.textview2);
            status = itemView.findViewById(R.id.textview3);

        }
    }
}

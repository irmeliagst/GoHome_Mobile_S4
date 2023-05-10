package com.example.gohome_mobile_s4.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gohome_mobile_s4.Model.CheckinModel;
import com.example.gohome_mobile_s4.R;



import java.util.List;

public class CheckinAdapter extends RecyclerView.Adapter <CheckinAdapter.Viewholder>{
    private List<CheckinModel> checkinModelList;

    public CheckinAdapter(List<CheckinModel>checkinModelList){
        this.checkinModelList = checkinModelList;
    }
    @NonNull
    @Override
    public CheckinAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaksi_item, parent, false);
        return new CheckinAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int resource = checkinModelList.get(position).getImageview();
        String jKamar = checkinModelList.get(position).getTextview1();
        String harga = checkinModelList.get(position).getTextview2();
        String status = checkinModelList.get(position).getTextview3();
        holder.setData(resource, jKamar, harga, status);
    }


    @Override
    public int getItemCount() {
        if (checkinModelList != null) {
            return checkinModelList.size();
        }
        return 0;
    }
    public  class  Viewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView1 = itemView.findViewById(R.id.textview);
            textView2 = itemView.findViewById(R.id.textview2);
            textView3 = itemView.findViewById(R.id.textview3);

        }

        public void setData(int resource, String jKamar, String harga, String status) {
            imageView.setImageResource(resource);
            textView1.setText(jKamar);
            textView2.setText(harga);
            textView3.setText(status);
        }
    }
}

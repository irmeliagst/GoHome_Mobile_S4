package com.example.gohome_mobile_s4.Adapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.gohome_mobile_s4.CheckinFragment;
import com.example.gohome_mobile_s4.CheckoutFragment;
import com.example.gohome_mobile_s4.MenungguFragment;

public class transaksiAdapter extends FragmentStateAdapter {

    public transaksiAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public transaksiAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MenungguFragment();
            case 1: return new CheckinFragment();
            case 2: return new CheckoutFragment();
            default:return new MenungguFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

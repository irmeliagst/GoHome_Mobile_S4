package com.example.gohome_mobile_s4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gohome_mobile_s4.Adapter.transaksiAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TransaksiFragment extends Fragment {


    public TransaksiFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewpager1);
        FragmentStateAdapter adapter = new transaksiAdapter(getChildFragmentManager(), getLifecycle());
        viewPager2.setSaveEnabled(false);
        viewPager2.setAdapter(adapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // Set the tab titles.
            switch (position) {
                case 0:
                    tab.setText("Menunggu");
                    break;
                case 1:
                    tab.setText("Check In");
                    break;
                case 2:
                    tab.setText("Check Out");
                    break;
            }
        });
        tabLayoutMediator.attach();
        return view;
    }
}
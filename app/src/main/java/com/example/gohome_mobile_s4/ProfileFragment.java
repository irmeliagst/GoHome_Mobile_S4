package com.example.gohome_mobile_s4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gohome_mobile_s4.retrofit.ApiInterface;


public class ProfileFragment extends Fragment {
    SesionManager sesionManager;
    ApiInterface apiInterface;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView profileInitials = view.findViewById(R.id.profile_initials);
        TextView name_profile = view.findViewById(R.id.name_profile);
        sesionManager = new SesionManager(requireContext());
        // Ambil inisial dari nama dan tampilkan pada TextView
        String name = sesionManager.getUserDetail().get(SesionManager.NAMA_PENGUNJUNG);
        String initials = getInitials(name);
        profileInitials.setText(initials);
        name_profile.setText(name);
        Button btnprofile = view.findViewById(R.id.btnProfile);
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EdtprofActivity.class);
                startActivity(intent);
            }
        });
        Button btnfaq = view.findViewById(R.id.btnFaq);
        btnfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FaqActivity.class);
                startActivity(intent);
            }
        });
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Logout");
                builder.setMessage("Apakah anda yakin Logout");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Logout logic here
                        SesionManager sesionManager = new SesionManager(getContext());
                        sesionManager.logoutSession();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;

    }
    // untuk icon inisial
    private String getInitials(String name) {
        String[] nameParts = name.split("\\s+");
        if (nameParts.length > 0) {
            return String.valueOf(nameParts[0].charAt(0)).toUpperCase();
        } else {
            return "";
        }
    }
}
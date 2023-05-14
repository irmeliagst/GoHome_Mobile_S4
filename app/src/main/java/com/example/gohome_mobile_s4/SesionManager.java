package com.example.gohome_mobile_s4;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.gohome_mobile_s4.Model.login.LoginData;

import java.util.HashMap;

public class SesionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    public static final String ISLOGIN = "islogin" ;
    public static final String TOKEN = "token";
    public static final String EMAIL = "email";
    public static final String NIK = "nik";
    public static final String TELEPON = "telepon";
    public static final String NAMA_PENGUNJUNG = "nama_pengunjung";

    public SesionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }
    public void createLoginSession(LoginData user){
        editor.putBoolean(ISLOGIN, true);
        editor.putString(TOKEN, user.getToken());
        editor.putString(TELEPON, user.getTelepon());
        editor.putString(NAMA_PENGUNJUNG, user.getNamaPengunjung());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NIK, String.valueOf(user.getNik()));
        editor.commit();
    }
    public HashMap<String, String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(TOKEN, sharedPreferences.getString(TOKEN,null));
        user.put(TELEPON, sharedPreferences.getString(TELEPON,null));
        user.put(NAMA_PENGUNJUNG, sharedPreferences.getString(NAMA_PENGUNJUNG,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        user.put(NIK, sharedPreferences.getString(NIK,null));
        return user;

    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }
    public boolean isLogin(){
        return sharedPreferences.getBoolean(ISLOGIN, false);
}

}

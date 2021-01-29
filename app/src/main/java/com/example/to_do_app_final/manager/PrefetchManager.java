package com.example.to_do_app_final.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefetchManager {
    Context context;
    final static String Prefrance = "Prefrance";

    public PrefetchManager(Context context) {
        this.context = context;
    }

    public  void saveSignupDetail(String name,String email, String password, String phone, String gender){
        SharedPreferences preferences = context.getSharedPreferences(Prefrance,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.putString("phone",phone);
        editor.putString("gender",gender);
        editor.apply();

    }
    public  String getUserName(){
        SharedPreferences preferences = context.getSharedPreferences(Prefrance,Context.MODE_PRIVATE);
        return preferences.getString("name","");
    }

    public  Boolean isUserLogout(){
        SharedPreferences preferences = context.getSharedPreferences(Prefrance,Context.MODE_PRIVATE);
        return preferences.getString("email","").isEmpty();
    }

    public  void logOut(){
        SharedPreferences preferences = context.getSharedPreferences(Prefrance,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

    }


}

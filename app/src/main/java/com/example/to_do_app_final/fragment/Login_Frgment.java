package com.example.to_do_app_final.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.to_do_app_final.Activity.MainActivity;
import com.example.to_do_app_final.R;
import com.google.android.material.textfield.TextInputLayout;


public class Login_Frgment extends Fragment {

    ImageView ivTOp, ivBottom;
    TextInputLayout userName,password;
    Button forgetPass,login_btn,signUp_login;
    ImageButton facebook, gmail,twitter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login__frgment, container, false);

        ivTOp = view.findViewById(R.id.iv_top);
        ivBottom =view.findViewById(R.id.iv_bottom);
        userName = view.findViewById(R.id.userName);
        password = view.findViewById(R.id.password);
        forgetPass =view.findViewById(R.id.forgetPass);
        login_btn = view.findViewById(R.id.login_btn);
        signUp_login = view.findViewById(R.id.signUp_lgn);
        facebook = view.findViewById(R.id.facebook);
        gmail = view.findViewById(R.id.gmail);
        twitter = view.findViewById(R.id.twitter);

        facebookLogin(view);
        gmailLogin(view);
        twitterLogin(view);
        loginForm(view);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // for animation top

        Animation animationtop = AnimationUtils.loadAnimation(getContext(),R.anim.top_wave);
        ivTOp.setAnimation(animationtop);


        // for animation bottom
        Animation animationBottom = AnimationUtils.loadAnimation(getContext(),R.anim.bottom_wave);
        ivBottom.setAnimation(animationBottom);



        return view;

    }
    private void loginForm( View view){

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void facebookLogin(View view){
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com/";
                String urlFacebook = "http://www.facebook.com/";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }
            }
        });

    }

    private void gmailLogin(View view){
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com/";
                String urlFacebook = "http://www.gmail.com/";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }

            }
        });
    }

    private void twitterLogin(View view){
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com/";
                String urlFacebook = "http://www.twitter.com/";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook)));
                }
            }
        });
    }


}
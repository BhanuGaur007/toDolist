package com.example.to_do_app_final.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.to_do_app_final.Activity.MainActivity;
import com.example.to_do_app_final.R;
import com.example.to_do_app_final.manager.PrefetchManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp_Screen extends Fragment {
    ImageView ivTOp, ivBottom;
    TextInputEditText name,password,phone,email;
    Button register;
    ImageButton facebook, gmail,twitter;
    RadioGroup gender;
   // RadioButton male,female;
    String genderValue="MALE";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up__screen, container, false);
        ivTOp = view.findViewById(R.id.iv_top);
        ivBottom =view.findViewById(R.id.iv_bottom);
        name = view.findViewById(R.id.name);
        password = view.findViewById(R.id.password);
        phone = view.findViewById(R.id.phone);
        email = view.findViewById(R.id.email);
        gender = view.findViewById(R.id.gender);
        register = view.findViewById(R.id.register);
        facebook = view.findViewById(R.id.facebook);
        gmail = view.findViewById(R.id.gmail);
        twitter = view.findViewById(R.id.twitter);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // for animation top

        Animation animationtop = AnimationUtils.loadAnimation(getContext(),R.anim.top_wave);
        ivTOp.setAnimation(animationtop);


        // for animation bottom
        Animation animationBottom = AnimationUtils.loadAnimation(getContext(),R.anim.bottom_wave);
        ivBottom.setAnimation(animationBottom);

        genderValue(view);
        facebookLogin(view);
        gmailLogin(view);
        twitterLogin(view);
        register(view);

        return view;

    }

private void genderValue(View view){
gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int childCount = group.getChildCount();
        for (int x = 0; x < childCount; x++) {
            RadioButton btn  = (RadioButton) group.getChildAt(x);
            if(btn.getId()==R.id.male){
                btn.setText("MALE");
            }else{
                btn.setText("FEMALE");
            }
            if (btn.getId() == checkedId) {
                genderValue = btn.getText().toString();
               // gender=btn.getText().toString();

            }


        }
        Log.e("Gender",genderValue);
    }
});
}
    private void register(View view) {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PrefetchManager(getContext()).saveSignupDetail(name.getText().toString(),email.getText().toString(),password.getText().toString(),
                        phone.getText().toString(),genderValue);


                Intent intent = new Intent(getContext(), Profile.class);
                intent.putExtra("name",name.getText().toString());
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
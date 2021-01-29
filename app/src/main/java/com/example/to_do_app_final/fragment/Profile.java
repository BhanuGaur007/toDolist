package com.example.to_do_app_final.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.to_do_app_final.Activity.MainActivity;
import com.example.to_do_app_final.R;
import com.example.to_do_app_final.manager.PrefetchManager;

public class Profile extends Fragment {
    TextView name,email,phone,gender;
    ImageView ivTOp,ivBottom;
    String nameString,firstName;

    private ActionBar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = view.findViewById(R.id.namefragment);
        email = view.findViewById(R.id.emailfragment);
        phone = view.findViewById(R.id.phonefragment);
        gender = view.findViewById(R.id.genderfragment);
        ivTOp = view.findViewById(R.id.iv_top);
        ivBottom = view.findViewById(R.id.iv_bottom);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // for animation top

        Animation animationtop = AnimationUtils.loadAnimation(getContext(),R.anim.top_wave);
        ivTOp.setAnimation(animationtop);


        // for animation bottom
        Animation animationBottom = AnimationUtils.loadAnimation(getContext(),R.anim.bottom_wave);
        ivBottom.setAnimation(animationBottom);
        nameString =getActivity().getIntent().getStringExtra("name");

        name.setText(firstName);

        return view;
    }
}
package com.example.to_do_app_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.to_do_app_final.R;
import com.example.to_do_app_final.fragment.HomeFragment;
import com.example.to_do_app_final.manager.PrefetchManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ImageView ivTOp,ivBottom,iv_add;
    AlertDialog.Builder builder;

    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    private ActionBar toolbar;
    String value=" ";

    public FragmentCommunicator fragmentCommunicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTOp = findViewById(R.id.iv_top);
        ivBottom = findViewById(R.id.iv_bottom);
        iv_add = findViewById(R.id.iv_add);
        builder = new AlertDialog.Builder(this);

        setTitle("Home");

        toolbar = getSupportActionBar();
       iv_add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
               final EditText input = new EditText(MainActivity.this);
               LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                       LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.MATCH_PARENT);
               input.setLayoutParams(lp);
               builder.setView(input);
//               builder.setMessage("Do you want to close this application ?");
               builder.setCancelable(false)
                       .setPositiveButton("Save", new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int id) {
                               //  Action for 'NO' Button

                               Toast.makeText(getApplicationContext(),"you Didn't save your Task",
                                       Toast.LENGTH_SHORT).show();
                               //value=input.getText().toString();
                               fragmentCommunicator.sendData(input.getText().toString());
                               dialog.cancel();
                           }

                       });


                 builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         finish();
                         Toast.makeText(getApplicationContext(),"you Save Your Task",
                                 Toast.LENGTH_SHORT).show();
                     }
               });


               AlertDialog alert = builder.create();
               alert.setTitle("Add New Task ");
               alert.show();

           }
       });

           getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

           Animation animationtop = AnimationUtils.loadAnimation(this,R.anim.top_wave);
           ivTOp.setAnimation(animationtop);


           Animation animationBottom = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);
           ivBottom.setAnimation(animationBottom);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(iv_add,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );
        objectAnimator.setDuration(400);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();

        addFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.action_profile:
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        break;
                    case R.id.action_fav:
                        Toast.makeText(MainActivity.this, "Fav", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


    }


    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle=new Bundle();
        bundle.putString("bundle",value);
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.add_fragment, fragment);
        fragmentTransaction.commit();
    }

    public interface  FragmentCommunicator {
        public void sendData(String value);
    }



}
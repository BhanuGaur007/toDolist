package com.example.to_do_app_final.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.to_do_app_final.Activity.MainActivity;
import com.example.to_do_app_final.Activity.RecyclerView;
import com.example.to_do_app_final.R;
public class HomeFragment extends Fragment implements MainActivity.FragmentCommunicator {
    TextView assignTask;
    String getvalue="";


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        assignTask = view.findViewById(R.id.assignTask);
//        Bundle bundle = this.getArguments();
//        String myValue = bundle.getString("bundle");
//        assignTask.setText(myValue);

        assignTask(view);
        return view;
    }

    private void assignTask(View view) {


        assignTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RecyclerView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void sendData(String value) {
        getvalue=value;
        assignTask.setText(getvalue);
    }
}
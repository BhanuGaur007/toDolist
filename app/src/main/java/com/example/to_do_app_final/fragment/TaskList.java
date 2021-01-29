package com.example.to_do_app_final.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.to_do_app_final.R;
import com.example.to_do_app_final.adapter.TaskAddRecyclerAdapter;
import com.example.to_do_app_final.model.TaskAddRecyclerModel;

import java.util.ArrayList;

public class TaskList extends Fragment {
    RecyclerView recyclerView;
    ArrayList<TaskAddRecyclerModel> arrayList = new ArrayList<>();
    TaskAddRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_task_list, container, false);
        inisilization(view);
        return view;
    }



    private  void inisilization(View view){

        recyclerView = view.findViewById(R.id.notesTask);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TaskAddRecyclerAdapter(getContext(),arrayList);
        arrayList.add(new TaskAddRecyclerModel("This is task One "));
        arrayList.add(new TaskAddRecyclerModel("This is task Two "));
        arrayList.add(new TaskAddRecyclerModel("This is task Three "));
        arrayList.add(new TaskAddRecyclerModel("This is task Four "));
        arrayList.add(new TaskAddRecyclerModel("This is task Five "));
        arrayList.add(new TaskAddRecyclerModel("This is task Six "));
        arrayList.add(new TaskAddRecyclerModel("This is task Seven "));
        arrayList.add(new TaskAddRecyclerModel("This is task Eight "));

        recyclerView.setAdapter(adapter);



    }
}
package com.example.fujitsu.mojprojekat.activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fujitsu.mojprojekat.R;
import com.example.fujitsu.mojprojekat.activity.async.SimpleSyncTask;
import com.example.fujitsu.mojprojekat.activity.providers.MealProvider;

import java.util.List;


public class MasterFragment extends Fragment {

    public interface OnProductSelectedListener {
        void onProductSelected(int id);
    }


    public interface OnItemSelectedListener {

        void onItemSelected(int position);
    }

    OnItemSelectedListener listener;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

       return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

     SimpleSyncTask task = new SimpleSyncTask(getActivity());
     task.execute();

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

    }

}
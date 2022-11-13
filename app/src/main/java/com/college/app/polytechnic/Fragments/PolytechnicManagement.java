package com.college.app.polytechnic.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PolytechnicManagement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PolytechnicManagement extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_polytechnic_management, container, false);
    }
}
package com.college.app.polytechnic.bottomnavigation.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.app.R;
import com.college.app.polytechnic.Adapters.ViewPageMainAdapter;
import com.google.android.material.tabs.TabLayout;

public class Home extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout= view.findViewById(R.id.MainTabLayout);
        viewPager=view.findViewById(R.id.polytechnic_viewPager);
        _tabLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);

        return  view;
    }



    private void _tabLayout() {

        ViewPageMainAdapter adapter = new ViewPageMainAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}
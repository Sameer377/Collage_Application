package com.college.app.polytechnic.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.college.app.R;
import com.college.app.polytechnic.Polytechnic;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class PolytechnicHome extends Fragment {

    private ScrollView scrollView;
    private ImageSlider imageSlider;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initUi(view);
        sliderImage();
    }

    private void initUi(View view) {
        scrollView = view.findViewById(R.id.FragHomeScrollView);
        imageSlider=view.findViewById(R.id.frag_home_img_slider);
        ((Polytechnic)getActivity()).isScrollingDown(scrollView);
    }

    private void sliderImage() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2FBest_Principal.jpg?alt=media&token=dd7ea6a2-ea1a-4028-b3f2-93be886c3d43", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fprin.jpg?alt=media&token=2bd88912-c544-4829-a179-6a03b5ed4ac2", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Finfra.jpg?alt=media&token=e4a1cbe6-a15e-44f1-a5fa-5a1d225604b9", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Flab.jpg?alt=media&token=7dce08e1-aa67-4295-8a9b-fb7ab26f5ae3", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fmec.jpg?alt=media&token=0cc17984-17d4-46b3-a347-a80e752186f7", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_polytechnic_home, container, false);
    }
}
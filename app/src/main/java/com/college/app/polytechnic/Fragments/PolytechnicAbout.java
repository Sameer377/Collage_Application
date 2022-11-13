package com.college.app.polytechnic.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.college.app.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class PolytechnicAbout extends Fragment {

    private ImageSlider aboutImageSlider,visionImageSlider,missionImageSlider,campusImageSlider;
    private TextView campustxt;
    public PolytechnicAbout() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    String imgDis[]={"Fifteen Acres Landscaped Area With Excellent Infra-Structural Facilities",
                     "Highly Qualified & Experienced Staff.",
                     "Spacious Ventilated & Modem Classroom With Latest Teaching Aids",
                     "Well Equipped Laboratories With Latest Equipment And Advanced Machineries In Workshop- CNC Machines",
                     "Rich Entrepreneurship Cell",
                     "Strong Industry-Institute Interaction",
                     "24 Hrs .Full Power Backup",
                     "Play Ground",
                     "Indoor & Outdoor Sports Facilities",
                     "Free Medical Facility For Hostel Students",
                     "Wi-Fi Connectivity To Whole Campus With Advanced Computer Center",
                     "RO/UV Purified Drinking Water Facilities",
                     "Entire Campus Under CCTV Surveillance",
                     "Jagruti – A Women Cell Established For Girl Students & Ladies Staff",
                     "Campus Placement By Reputed Companies",
                     "Digital Library With Book Bank facility",
                     "Insurance Facility To All Students",
                     "Personal Care To Every Student And Full-Fledged Hostel Facility",
                     "\"Centre For Excellence\" For Overall Development of Student",
                     "Bus Facility"};

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        aboutImageSlider=view.findViewById(R.id.about_img_slider);
        visionImageSlider=view.findViewById(R.id.vision_img_slider);
        missionImageSlider=view.findViewById(R.id.mission_img_slider);
        campusImageSlider=view.findViewById(R.id.campus_slider);
        campustxt=view.findViewById(R.id.campus_cv_txt);

        aboutSliderImage("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Finfra.jpg?alt=media&token=ec8f1f06-02f3-471c-811c-dd6f7637b1cf",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Finfra2.jpg?alt=media&token=11cb1216-e515-4af5-9d98-a86de2947ff9",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Finfra3.jpg?alt=media&token=e37e1c5c-7d94-4122-8bcd-c4b548784474",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Finfra4.jpg?alt=media&token=e47f7759-843f-422d-a890-02f637b4685f",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Flab.jpg?alt=media&token=18175563-f242-4890-b870-f35a94725b7a",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Flab2.jpg?alt=media&token=6169e8ec-17ac-42ca-a5d7-82e87930982a",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fec_infra.jpg?alt=media&token=685e0db5-2c21-4c57-b0fc-ca7b6289bafd",
                        "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fcanteen.jpg?alt=media&token=2b153bac-cf59-4c0a-9b25-4874a9c6f57a");
       visionSliderImage("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fvision.jpg?alt=media&token=49102095-c9ac-43a5-a7ae-73ea2edb8e58");
       missionSliderImage("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fmission.jpg?alt=media&token=21df9c6d-f2e0-41a0-9396-46e0fdce5030");
       campusSliderImage("https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2FClg_infra.png?alt=media&token=1b7ff9ef-cf69-45f2-93c1-09df9cbe8c49",
               "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fclg_staff.jpg?alt=media&token=bc65e650-1310-4c4c-80ad-04f76eed254f",
               "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Flab.jpg?alt=media&token=2534ab71-a420-4592-8876-891367cf83d3",
               "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fclg_machinaries.jpg?alt=media&token=0cb7de61-6518-4156-ba78-1ee0b2c7ff08",
               "https://firebasestorage.googleapis.com/v0/b/page1-f073e.appspot.com/o/demo%2Fclg_classroom.jpg?alt=media&token=abcb0d84-9718-429e-ada5-370639a55e61");

    }

    private void aboutSliderImage(String... urls) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for(String Url:urls){
            slideModels.add(new SlideModel(Url, ScaleTypes.FIT));

        }
        aboutImageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }

    private void visionSliderImage(String... urls) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for(String Url:urls){
            slideModels.add(new SlideModel(Url, ScaleTypes.FIT));

        }
        visionImageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }

    private void campusSliderImage(String... urls) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for(String Url:urls){
            slideModels.add(new SlideModel(Url, ScaleTypes.FIT));

        }
        campusImageSlider.setImageList(slideModels,ScaleTypes.FIT);
        campusImageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {

            }
        });
       campusImageSlider.setItemChangeListener(new ItemChangeListener() {
           @Override
           public void onItemChanged(int i) {
               campustxt.setText(imgDis[i]);
           }
       });
    }

    private void missionSliderImage(String... urls) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for(String Url:urls){
            slideModels.add(new SlideModel(Url, ScaleTypes.FIT));

        }
        missionImageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_polytechnic_about, container, false);
    }
}
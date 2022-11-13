package com.college.app.polytechnic.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.college.app.polytechnic.Fragments.PolytechnicAbout;
import com.college.app.polytechnic.Fragments.PolytechnicHome;
import com.college.app.polytechnic.Fragments.PolytechnicManagement;

public class ViewPageMainAdapter extends FragmentStatePagerAdapter {

    public ViewPageMainAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

       if(position==0){
           return new PolytechnicHome();
       }else if(position==1){
           return new PolytechnicAbout();
       }
       else if(position==2){
           return new PolytechnicAbout();
       }
       else if(position==3){
           return new PolytechnicAbout();
       }
       else if(position==4){
           return new PolytechnicAbout();
       }
       else if(position==5){
           return new PolytechnicAbout();
       }
       else if(position==6){
           return new PolytechnicAbout();
       }
       else if(position==7){
           return new PolytechnicAbout();
       }
       else {
           return new PolytechnicManagement();
       }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
           return "Home";
        }else if(position==1){
            return "About Us";

        }
        else if(position==2){
            return "Admission";

        }
        else if(position==3){
            return "Course";

        }
        else if(position==4){
            return "Facilities";

        }
        else if(position==5){
            return "Academic";

        }
        else if(position==6){
            return "Faculty";

        }
        else if(position==7){
            return "Media";

        }
        else {
            return "Contact Us";

        }
    }

    @Override
    public int getCount() {
        return 9; //no of fragment
    }
}

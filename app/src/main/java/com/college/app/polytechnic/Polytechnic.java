package com.college.app.polytechnic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.college.app.R;
import com.college.app.polytechnic.bottomnavigation.Fragments.Downloads;
import com.college.app.polytechnic.bottomnavigation.Fragments.Home;
import com.college.app.polytechnic.bottomnavigation.Fragments.NewsLetter;
import com.college.app.polytechnic.bottomnavigation.Fragments.PhotoGallary;
import com.college.app.polytechnic.bottomnavigation.Fragments.Sports;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Polytechnic extends AppCompatActivity   {
    private Context context=Polytechnic.this;
    public DrawerLayout drawerLayout;
    private AppBarLayout main_appbar_Layout;
    private Toolbar toolbar;
    private ImageView nav_btn;
    private EditText searchBar;
    private BottomNavigationView MainBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polytechnic);
        setSupportActionBar(toolbar);

        initUi();
        initListner();
        _navDrawer();
        bottomNavigationView();

    }


    private void initUi() {
        main_appbar_Layout=findViewById(R.id.main_appbar_Layout);
        toolbar=findViewById(R.id.polytechnic_toolBar);
        nav_btn=findViewById(R.id.polytechnic_nav_btn);
        drawerLayout = findViewById(R.id.lay_polytechnic_nav_drawer);
        MainBottomNavigationView=findViewById(R.id.MainBottomNavigationView);

        MainBottomNavigationView.setSelectedItemId(R.id.Home);
        loadFragment(new Home(),true);
//        searchBar=findViewById(R.id.polytechnic_searchBar);
    }



    private void initListner() {

    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.polytechnic_nav_btn:

                    if(!drawerLayout.isOpen()){
                        drawerLayout.open();
                    }
                    else {
                        drawerLayout.close();
                    }

                break;
        }
    }


    private void _navDrawer(){

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                nav_btn.setImageResource(R.drawable.ic_baseline_close_white);

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                nav_btn.setImageResource(R.drawable.ic_baseline_menu_24);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        
        if(drawerLayout.isOpen()){
            
            drawerLayout.close();
            
        }else{
            Toast.makeText(this, "Press Back for Exit", Toast.LENGTH_SHORT).show();
        }
        

    }

    private void bottomNavigationView(){

        MainBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                if(id==R.id.Sports){
                    HeaderState("Sports",true);
                    loadFragment(new Sports(),false);
                }
                else if(id==R.id.PhotoGallary){
                    HeaderState("Photo Gallery",true);
                    loadFragment(new PhotoGallary(),false);
                }
                else if(id==R.id.NewsLetter){
                    HeaderState("News Letters & Events",true);
                    loadFragment(new NewsLetter(),false);
                }
                else if(id==R.id.Downloads){
                    HeaderState("Downloads",true);
                    loadFragment(new Downloads(),false);
                }
                else{
                    HeaderState(null,false);
                    loadFragment(new Home(),false);
                }
                return true;
            }
        });
    }

    private void HeaderState(String header, boolean status){

        RelativeLayout relativeLayout = findViewById(R.id.rel_header_layout);

        TextView headertext=findViewById(R.id.FragmentHeaderTitle);
        headertext.setText(header);
        if (status) {
            relativeLayout.setVisibility(View.VISIBLE);
        } else {
            relativeLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void loadFragment(Fragment fragment,boolean flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(flag) {
            ft.add(R.id.FrameMain, fragment);
        }
            else {
            ft.replace(R.id.FrameMain,fragment);
        }
        ft.commit();

    }


    public void isScrollingDown(ScrollView scrollView){



        scrollView.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {


                        if (!scrollView.canScrollVertically(1)) {
                            // bottom of scroll view
                            MainBottomNavigationView.setVisibility(View.VISIBLE);
                        }
                        if (!scrollView.canScrollVertically(-1)) {
                            // top of scroll view
                            MainBottomNavigationView.setVisibility(View.VISIBLE);

                        }


                            //scroll view is not at bottom
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                                    @Override
                                    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                                        if(scrollY<=oldScrollY)
                                        {
                                            //scroll up
                                            MainBottomNavigationView.setVisibility(View.VISIBLE);
                                        }
                                        else {
                                            MainBottomNavigationView.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            }

                    }
                });

    }

    public void hideToolBarOnScroll(boolean status){
        if(status) {
            toolbar.setVisibility(View.GONE);
        }else {
            toolbar.setVisibility(View.VISIBLE);
        }
    }
    

}
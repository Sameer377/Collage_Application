package com.college.app.polytechnic.initials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.college.app.R;
import com.college.app.polytechnic.Polytechnic;

public class SignupActivity extends AppCompatActivity {

    private ImageView login_logo_img;
    private TextView Back,Skip,Signup,login,Description,Event;
    private EditText Username,Email,Mobile,NewPassword,ConfirmPassword;
    private RelativeLayout rel_newpassword_Signup,rel_confirmPassword_SignUp,rel_username_signup,rel_email_signup,rel_mobile_signup,
                           rel_About_signup;
    private MultiAutoCompleteTextView About;
    private LinearLayout lin_otp_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initUi();
        _signUpWorking();
    }

    private void initUi() {
        Back= findViewById(R.id.btn_back_signup);
        Skip= findViewById(R.id.btn_skip_signup);
        Signup=findViewById(R.id.signup_btn_signup);
        Event=findViewById(R.id.txt_signup);
        login_logo_img=findViewById(R.id.login_logo_img);
        login_logo_img.setImageResource(R.drawable.agppi_logo);
        //Details
        //Edittext
        Username=findViewById(R.id.username_edt_signup);
        Email=findViewById(R.id.Email_edt_signup);
        Mobile= findViewById(R.id.mobile_edt_signup);
        About= findViewById(R.id.about_edt_signup);
        login=findViewById(R.id.Login_tv_signup);

        //Relativelayout
        rel_username_signup=findViewById(R.id.rel_username_signup);
        rel_email_signup =findViewById(R.id.rel_email_signup);
        rel_mobile_signup=findViewById(R.id.rel_mobile_signup);
        rel_About_signup=findViewById(R.id.rel_About_signup);

        //OTP
        Description=findViewById(R.id.txt_description_signup);
        lin_otp_edt=findViewById(R.id.lin_otp_edt);

        //Password
        rel_newpassword_Signup=findViewById(R.id.rel_newpassword_Signup);
        rel_confirmPassword_SignUp=findViewById(R.id.rel_confirmPassword_SignUp);



        Event.setText(R.string.Sign_up);
        Signup.setText("SignUp");

        //showing signup content
        rel_username_signup.setVisibility(View.VISIBLE);
        rel_email_signup.setVisibility(View.VISIBLE);
        rel_mobile_signup.setVisibility(View.VISIBLE);
        rel_About_signup.setVisibility(View.VISIBLE);

        //hiding otp & Password content
        rel_newpassword_Signup.setVisibility(View.GONE);
        rel_confirmPassword_SignUp.setVisibility(View.GONE);
        lin_otp_edt.setVisibility(View.GONE);
        Description.setVisibility(View.GONE);

    }

    private void _signUpWorking() {

        Intent intent = new Intent(SignupActivity.this, Polytechnic.class);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             if(Signup.getText().toString().trim().equals("SignUp")){
                    //while showing otp content

                    login_logo_img.setImageResource(R.drawable.ic_baseline_mark_email_read_24);
                    Event.setText(R.string.Verify_Email);
                    Description.setText(R.string.email_description);
                    Signup.setText("Verify");

                    //Showing otp  content
                    lin_otp_edt.setVisibility(View.VISIBLE);
                    Description.setVisibility(View.VISIBLE);

                    //hiding signup content
                    rel_username_signup.setVisibility(View.GONE);
                    rel_email_signup.setVisibility(View.GONE);
                    rel_mobile_signup.setVisibility(View.GONE);
                    rel_About_signup.setVisibility(View.GONE);
                    rel_newpassword_Signup.setVisibility(View.GONE);
                    rel_confirmPassword_SignUp.setVisibility(View.GONE);

                }else if(Signup.getText().toString().trim().equals("Verify")){
                    //while showing password content
                    login_logo_img.setImageResource(R.drawable.ic_baseline_lock_logo);
                    Event.setText(R.string.set_password);
                    Description.setText(R.string.setPassword);
                    Signup.setText("Save");

                    //Showing password  content
                    rel_newpassword_Signup.setVisibility(View.VISIBLE);
                    rel_confirmPassword_SignUp.setVisibility(View.VISIBLE);
                    Description.setVisibility(View.VISIBLE);

                    //hiding signup content
                    lin_otp_edt.setVisibility(View.GONE);
                    rel_username_signup.setVisibility(View.GONE);
                    rel_email_signup.setVisibility(View.GONE);
                    rel_mobile_signup.setVisibility(View.GONE);
                    rel_About_signup.setVisibility(View.GONE);


                }else if(Signup.getText().toString().trim().equals("Save")){
                 startActivity(intent);
                 finish();
                }

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Signup.getText().toString().trim().equals("SignUp")){
                    finish();
                }else if(Signup.getText().toString().trim().equals("Verify")){
                    login_logo_img.setImageResource(R.drawable.agppi_logo);
                    Event.setText("Sign Up");
                    Description.setText(R.string.email_description);
                    Signup.setText("SignUp");

                    //hiding otp  content
                    lin_otp_edt.setVisibility(View.GONE);
                    Description.setVisibility(View.GONE);

                    //Showing signup content
                    rel_username_signup.setVisibility(View.VISIBLE);
                    rel_email_signup.setVisibility(View.VISIBLE);
                    rel_mobile_signup.setVisibility(View.VISIBLE);
                    rel_About_signup.setVisibility(View.VISIBLE);
                    rel_newpassword_Signup.setVisibility(View.GONE);
                    rel_confirmPassword_SignUp.setVisibility(View.GONE);
                }else if(Signup.getText().toString().trim().equals("Save")){
                    login_logo_img.setImageResource(R.drawable.agppi_logo);
                    Event.setText("Sign Up");
                    Description.setText(R.string.email_description);
                    Signup.setText("SignUp");

                    //Showing otp  content
                    lin_otp_edt.setVisibility(View.GONE);
                    Description.setVisibility(View.GONE);

                    //hiding signup content
                    rel_username_signup.setVisibility(View.VISIBLE);
                    rel_email_signup.setVisibility(View.VISIBLE);
                    rel_mobile_signup.setVisibility(View.VISIBLE);
                    rel_About_signup.setVisibility(View.VISIBLE);
                    rel_newpassword_Signup.setVisibility(View.GONE);
                    rel_confirmPassword_SignUp.setVisibility(View.GONE);
                }
            }
        });
    }
}
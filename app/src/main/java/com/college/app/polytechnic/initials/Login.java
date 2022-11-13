package com.college.app.polytechnic.initials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.college.app.R;
import com.college.app.polytechnic.Polytechnic;

public class Login extends AppCompatActivity {
    private TextView Login_btn,login_description,forgotpass,signup,newuser,back,btn_skip_login;
    private RelativeLayout Username,Password,progress_circular;
    private LinearLayout lin_otp;
    private  String flag="login";
    private EditText[] editTexts;
    private EditText otp_edit_1,otp_edit_2,otp_edit_3,otp_edit_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initui();
        loginWork();

    }

    private void loginWork() {

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupAct=new Intent(Login.this,SignupActivity.class);
                startActivity(signupAct);

            }
        });

        Intent intent = new Intent(Login.this, Polytechnic.class);
        btn_skip_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag.equals("otp")){
                    displayOtp(false);
                }else if(flag.equals("login")){
                    finish();
                }
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Login_btn.getText().toString().trim().equals("Login")){
                    flag="otp";
                    displayOtp(true);
                }else {
                    progress_circular.setVisibility(View.VISIBLE);
                    flag="login";
                    startActivity(intent);
                    finish();
                }


            }
        });
    }

    private void displayOtp(boolean status){

        if(status){
            flag="otp";
            forgotpass.setText("Resend otp");
            Username.setVisibility(View.GONE);
            Password.setVisibility(View.GONE);
            login_description.setVisibility(View.VISIBLE);
            lin_otp.setVisibility(View.VISIBLE);
            Login_btn.setText("Verify");
            signup.setVisibility(View.GONE);
            newuser.setVisibility(View.GONE);
        }else {
            flag="login";
            forgotpass.setText("Forgot Password ?");
            Username.setVisibility(View.VISIBLE);
            Password.setVisibility(View.VISIBLE);
            login_description.setVisibility(View.GONE);
            lin_otp.setVisibility(View.GONE);
            Login_btn.setText("Login");
            signup.setVisibility(View.VISIBLE);
            newuser.setVisibility(View.VISIBLE );
        }

    }

    private void initui() {
        back=findViewById(R.id.btn_back_login);
        newuser=findViewById(R.id.txt_new_user);
        signup=findViewById(R.id.login_signup_txt);
        forgotpass=findViewById(R.id.forgot_password_login);
        Login_btn=findViewById(R.id.login_btn);
        lin_otp=findViewById(R.id.lin_otp_edt);
        Username=findViewById(R.id.rel_username_login);
        Password=findViewById(R.id.rel_password_login);
        login_description=findViewById(R.id.txt_description);
        btn_skip_login=findViewById(R.id.btn_skip_login);
        progress_circular=findViewById(R.id.progress_circular);

        /* Otp Edittext */

        otp_edit_1=findViewById(R.id.otp_edt_1);
        otp_edit_2=findViewById(R.id.otp_edt_2);
        otp_edit_3=findViewById(R.id.otp_edt_3);
        otp_edit_4=findViewById(R.id.otp_edt_4);

        editTexts = new EditText[]{otp_edit_1, otp_edit_2, otp_edit_3, otp_edit_4};
        
        otp_edit_1.addTextChangedListener(new PinTextWatcher(0));
        otp_edit_2.addTextChangedListener(new PinTextWatcher(1));
        otp_edit_3.addTextChangedListener(new PinTextWatcher(2));
        otp_edit_4.addTextChangedListener(new PinTextWatcher(3));

        otp_edit_1.setOnKeyListener(new PinOnKeyListener(0));
        otp_edit_2.setOnKeyListener(new PinOnKeyListener(1));
        otp_edit_3.setOnKeyListener(new PinOnKeyListener(2));
        otp_edit_4.setOnKeyListener(new PinOnKeyListener(3));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(flag.equals("otp")){
            displayOtp(false);
        }else {
           finish();
        }

    }


    public class PinTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }


        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            /* Detect paste event and set first char */
            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1) {
                moveToNext();
            }
                else if (text.length() == 0)
            {
                int otp_t_flag=1;
                if(otp_t_flag==1){
                    otp_t_flag--;
                }else{
                    moveToPrevious();
                }
                otp_t_flag=1;

            }


        }

        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }

    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }


    }
}
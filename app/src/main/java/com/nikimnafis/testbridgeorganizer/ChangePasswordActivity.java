package com.nikimnafis.testbridgeorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;

    private EditText txtOldPass, txtNewPass, txtRNewPass;

    private boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        btnBack = findViewById(R.id.btn_back);
        txtOldPass = findViewById(R.id.inp_old_pass);
        txtNewPass = findViewById(R.id.inp_new_pass);
        txtRNewPass = findViewById(R.id.inp_new_pass2);


        btnBack.setOnClickListener(this);

        txtOldPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (event.getRawX()>=txtOldPass.getRight()-txtOldPass.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = txtOldPass.getSelectionEnd();
                        if (passwordVisible) {
                            // set gambar
                            txtOldPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            // menyembunyikan password
                            txtOldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            // set gambar
                            txtOldPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            // menyembunyikan password
                            txtOldPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtOldPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        txtNewPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (event.getRawX()>=txtNewPass.getRight()-txtNewPass.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = txtNewPass.getSelectionEnd();
                        if (passwordVisible) {
                            // set gambar
                            txtNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            // menyembunyikan password
                            txtNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            // set gambar
                            txtNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            // menyembunyikan password
                            txtNewPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtNewPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        txtRNewPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (event.getRawX()>=txtRNewPass.getRight()-txtRNewPass.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = txtRNewPass.getSelectionEnd();
                        if (passwordVisible) {
                            // set gambar
                            txtRNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            // menyembunyikan password
                            txtRNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            // set gambar
                            txtRNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            // menyembunyikan password
                            txtRNewPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtRNewPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_back:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
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
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEmail, inputPassword;
    boolean passwordVisible;
    private TextView buttonDaftar, buttonLupaPassword;
    private ImageButton buttonMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inp_email);
        inputPassword = findViewById(R.id.inp_pass);

        buttonDaftar = findViewById(R.id.btn_daftar);
        buttonMasuk = findViewById(R.id.btn_masuk);
        buttonLupaPassword = findViewById(R.id.btn_lupa_pass);

        buttonDaftar.setOnClickListener(this);
        buttonMasuk.setOnClickListener(this);
        buttonLupaPassword.setOnClickListener(this);

        inputPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (event.getRawX()>=inputPassword.getRight()-inputPassword.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = inputPassword.getSelectionEnd();
                        if (passwordVisible) {
                            // set gambar
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            // menyembunyikan password
                            inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            // set gambar
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            // menyembunyikan password
                            inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        inputPassword.setSelection(selection);
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
            case R.id.btn_daftar:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_masuk:
                if (!validasiEmail() | !validasiPassword()) {
                    return;
                }
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn_lupa_pass:
                startActivity(new Intent(this, LupaPasswordActivity.class));
                break;
        }
    }

//    Validasi input data
    public Boolean validasiEmail() {
        String val = inputEmail.getEditableText().toString();

        if (val.isEmpty()) {
            inputEmail.setError("Form harus diisi");
            return false;
        } else {
            inputEmail.setError(null);
            return true;
        }
    }
    public Boolean validasiPassword() {
        String val = inputPassword.getEditableText().toString();

        if (val.isEmpty()) {
            inputPassword.setError("Form harus diisi");
            return false;
        } else {
            inputPassword.setError(null);
            return true;
        }
    }


}
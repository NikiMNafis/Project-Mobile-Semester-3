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

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNama, inputNoTelp, inputEmail, inputPassword, inputUlangPassword;
    boolean passwordVisible;
    private ImageButton buttonBack, buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonBack = findViewById(R.id.btn_back);
        buttonDaftar = findViewById(R.id.btn_daftar);

        inputNama = findViewById(R.id.inp_nama);
        inputNoTelp = findViewById(R.id.inp_no_telp);
        inputEmail = findViewById(R.id.inp_email);
        inputPassword = findViewById(R.id.inp_pass);
        inputUlangPassword = findViewById(R.id.inp_ulang_pass);

        buttonBack.setOnClickListener(this);
        buttonDaftar.setOnClickListener(this);

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

        inputUlangPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (event.getRawX()>=inputUlangPassword.getRight()-inputUlangPassword.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = inputUlangPassword.getSelectionEnd();
                        if (passwordVisible) {
                            // set gambar
                            inputUlangPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            // menyembunyikan password
                            inputUlangPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            // set gambar
                            inputUlangPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            // menyembunyikan password
                            inputUlangPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        inputUlangPassword.setSelection(selection);
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
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_daftar:
                if (!validasiNama() | !validasiNoTelp() | !validasiEmail() | !validasiPassword() |
                    !validasiUlangPassword()) {
                    return;
                }
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    // Validasi Input Data
    public Boolean validasiNama() {
        String val = inputNama.getEditableText().toString();

        if (val.isEmpty()) {
            inputNama.setError("Form harus diisi");
            return false;
        } else {
            inputNama.setError(null);
            return true;
        }
    }
    public Boolean validasiNoTelp() {
        String val = inputNoTelp.getEditableText().toString();

        if (val.isEmpty()) {
            inputNoTelp.setError("Form harus diisi");
            return false;
        } else if (val.length()<=10){
            inputNoTelp.setError("Nomor telepon salah");
            return false;
        } else {
            inputNoTelp.setError(null);
            return true;
        }
    }
    public Boolean validasiEmail() {
        String val = inputEmail.getEditableText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            inputEmail.setError("Form harus diisi");
            return false;
        } else if (!val.matches(emailPattern)) {
            inputEmail.setError("Alamat email salah");
            return false;
        } else {
            inputEmail.setError(null);
            return true;
        }
    }
    public Boolean validasiPassword() {
        String val = inputPassword.getEditableText().toString();
        String passVal = "^" +
//                "(?=.*[0-9])" + //setidaknya 1 digit angka
//                "(?=.*[a-z])" + //setidaknya 1 huruf kecil
//                "(?=.*[A-Z])" + //setidaknya 1 huruf besar
                "(?=.*[a-zA-Z])" + //semua kerakter
                "(?=.*[@#$%^&+=])" + //setidaknya 1 spesial karakter
                "(?=\\s+$)" + //no white space
                ".{4,}" + //setidaknya 4 karakter
                "$";

        if (val.isEmpty()) {
            inputPassword.setError("Form harus diisi");
            return false;
        } else if (val.length()<=8) {
            inputPassword.setError("Password terlalu lemah");
            return false;
        } else {
            inputPassword.setError(null);
            return true;
        }
    }
    public Boolean validasiUlangPassword() {
        String val = inputUlangPassword.getEditableText().toString();
        String val2 = inputPassword.getEditableText().toString();

        if (val.isEmpty()) {
            inputUlangPassword.setError("Form harus diisi");
            return false;
        }  else if (val != val2) {
            inputUlangPassword.setError("Kata sandi tidak sama");
            return false;
        } else {
            inputUlangPassword.setError(null);
            return true;
        }
    }



}
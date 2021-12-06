package com.nikimnafis.testbridgeorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEmail, inputPassword;
    boolean passwordVisible;
    private TextView buttonDaftar, buttonLupaPassword;
    private ImageButton buttonMasuk;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inp_email);
        inputPassword = findViewById(R.id.inp_pass);

        mAuth = FirebaseAuth.getInstance();

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
//                if (!validasiEmail() | !validasiPassword()) {
//                    return;
//                }

                userLogin();

//                String email = inputEmail.getEditableText().toString().trim();
//                String password = inputPassword.getEditableText().toString().trim();

//                Query cekUser = FirebaseDatabase.getInstance().getReference("user").orderByChild("email").equalTo(email);
//
//                cekUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            inputEmail.setError(null);
//                            String systemPassword = snapshot.child("").child("password").getValue(String.class);
//                            if (systemPassword.equals(inputPassword)) {
//                                inputPassword.setError(null);
//                                String nama = snapshot.child("").child("nama").getValue(String.class);
//                                Toast.makeText(LoginActivity.this, "Selamat Datang" + nama, Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(LoginActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Akun tidak ada", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(LoginActivity.this, "Database error", Toast.LENGTH_SHORT).show();
//                    }
//                });

//                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn_lupa_pass:
                startActivity(new Intent(this, LupaPasswordActivity.class));
                break;
        }
    }

    private void userLogin() {
        if (!validasiEmail() | !validasiPassword()) {
            return;
        }

        String email = inputEmail.getEditableText().toString().trim();
        String password = inputPassword.getEditableText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Gagal login, silahkan coba lagi", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
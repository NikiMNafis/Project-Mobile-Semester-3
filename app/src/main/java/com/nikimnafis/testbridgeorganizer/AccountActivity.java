package com.nikimnafis.testbridgeorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    ImageButton btnBack;

    Button btnSave, btnDeleteAccount, btnLogOut;

    EditText edtNama, edtNoTelp, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnBack = findViewById(R.id.btn_back);
        btnLogOut = findViewById(R.id.btn_log_out);

        edtNama = findViewById(R.id.txt_view_nama);
        edtNoTelp = findViewById(R.id.txt_view_telp);
        edtEmail = findViewById(R.id.txt_view_email);

        btnBack.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserRegister userProfile = snapshot.getValue(UserRegister.class);

                if (userProfile != null) {
                    String namaUser = userProfile.nama;
                    String noTelpUser = userProfile.noTelp;
                    String emailUser = userProfile.email;

                    edtNama.setText(namaUser);
                    edtNoTelp.setText(noTelpUser);
                    edtEmail.setText(emailUser);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_back:
                startActivity(new Intent(AccountActivity.this, MainActivity.class));
                break;
            case R.id.btn_log_out:
                startActivity(new Intent(AccountActivity.this, LoginActivity.class));
                preferences.clearData(this);
                finish();
                break;
        }
    }

}
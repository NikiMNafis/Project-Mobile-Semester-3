package com.nikimnafis.testbridgeorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView navigationView;
    ImageView btnChat, btnAkun;
    TextView txtNamaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChat = findViewById(R.id.btn_chat);
        btnAkun = findViewById(R.id.btn_akun);
        txtNamaUser = findViewById(R.id.txt_nama_user);

        btnChat.setOnClickListener(this);
        btnAkun.setOnClickListener(this);

        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new ProjectFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_project);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_project:
                        fragment = new ProjectFragment();
                        break;
                    case R.id.nav_price_list:
                        fragment = new PriceListFragment();
                        break;
                    case R.id.nav_anggota:
                        fragment = new CrewFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return true;
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_chat:
                startActivity(new Intent(this, ChatActivity.class));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        cekuserstatus();
    }

    private void cekuserstatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
        Boolean status = sharedPreferences.getBoolean("loginstatus", Boolean.valueOf(String.valueOf(MODE_PRIVATE)));
        String username = sharedPreferences.getString("namauser", String.valueOf(MODE_PRIVATE));
        if (status) {
            txtNamaUser.setText(username);
        } else {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        }
    }
}
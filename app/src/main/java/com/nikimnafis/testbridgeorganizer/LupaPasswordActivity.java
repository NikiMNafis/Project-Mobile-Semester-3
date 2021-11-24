package com.nikimnafis.testbridgeorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LupaPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton buttonBack, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        buttonBack = findViewById(R.id.btn_back);
        buttonNext = findViewById(R.id.btn_next);

        buttonBack.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_back:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }

    }
}
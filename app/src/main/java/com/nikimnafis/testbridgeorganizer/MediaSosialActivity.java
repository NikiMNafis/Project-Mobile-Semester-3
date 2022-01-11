package com.nikimnafis.testbridgeorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MediaSosialActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnBack;

    RelativeLayout btnInstagram, btnTiktok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_sosial);

        btnBack = findViewById(R.id.btn_back);

        btnInstagram = findViewById(R.id.btn_instagram);
        btnTiktok = findViewById(R.id.btn_tiktok);

        btnBack.setOnClickListener(this);
        btnInstagram.setOnClickListener(this);
        btnTiktok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_back:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn_instagram:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bridgeorganizer__/"));
                startActivity(intent);
                break;
            case R.id.btn_tiktok:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@bridgeorganizer?"));
                startActivity(intent3);
                break;
        }
    }

}
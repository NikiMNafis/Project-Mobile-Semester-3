package com.nikimnafis.testbridgeorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailProjectActivity extends AppCompatActivity {

    ImageView imageDetailProject;
    TextView txtNamaProject, txtDetailProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);

        imageDetailProject = findViewById(R.id.img_detail_project);
        txtNamaProject = findViewById(R.id.txt_nama_project);
        txtDetailProject = findViewById(R.id.txt_detail_project);
    }

    public void onClick(View view) {
    }
}
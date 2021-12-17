package com.nikimnafis.testbridgeorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class DetailProjectActivity extends AppCompatActivity {

    ShapeableImageView imageDetailProject;

//    ImageView imageDetailProject;
    TextView txtNamaProject, txtDetailProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);

        imageDetailProject = findViewById(R.id.img_detail_project);
        txtNamaProject = findViewById(R.id.txt_nama_project);
        txtDetailProject = findViewById(R.id.txt_detail_project);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("nama");
            int selectedImage = intent.getIntExtra("image", 0);
            int selectedDetail = intent.getIntExtra("detail", 0);

            txtNamaProject.setText(selectedName);
            imageDetailProject.setImageResource(selectedImage);
            txtDetailProject.setText(selectedDetail);
        }
    }

    public void onClick(View view) {
    }
}
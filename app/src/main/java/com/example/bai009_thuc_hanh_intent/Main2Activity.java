package com.example.bai009_thuc_hanh_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView txt11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt11 = findViewById(R.id.txt11);
        Bundle bundle = getIntent().getExtras();
        //show data
        String upTxt = bundle.getString("guidata");
        txt11.setText("" + upTxt);
    }
}

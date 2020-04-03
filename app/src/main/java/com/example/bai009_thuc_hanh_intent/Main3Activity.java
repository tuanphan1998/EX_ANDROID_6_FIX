package com.example.bai009_thuc_hanh_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText edk1 , edk2 , edk3;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edk1 = findViewById(R.id.edk1);
        edk2 = findViewById(R.id.edk2);
        edk3 = findViewById(R.id.edk3);
        btn1 = findViewById(R.id.btn33);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usname = edk1.getText().toString();
                String pass = edk2.getText().toString();
                String passfix = edk3.getText().toString();

                if(usname.length() > 0 && pass.length() > 0 && passfix.length() > 0)
                {
                    if(pass.length() == passfix.length())
                    {
                        checkMK(usname , pass , passfix);
                    }
                    else if(pass.length()  != passfix.length() )
                    {
                        Toast.makeText(Main3Activity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Main3Activity.this, "Nhập đủ thông tin đi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void checkMK(String edusename , String edk1 , String edk2)
    {
            Intent i = new Intent();
            i.putExtra("usename" , ""+ edusename);
            i.putExtra("pass" , ""+ edk1);
            setResult(RESULT_OK , i);
            finish();
    }
}

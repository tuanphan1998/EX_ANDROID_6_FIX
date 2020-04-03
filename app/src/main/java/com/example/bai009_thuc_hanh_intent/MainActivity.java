package com.example.bai009_thuc_hanh_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed1 , ed2;
    private Button btn1;
    private TextView txt6 , btn2;
    int Event = 0;
    String Usename = "";
    String Pass = "";
    private static final  int SECONDARY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txt6 = findViewById(R.id.txt6);
        //enlabel btn 2
        // click kiem tra
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                String usename = ed1.getText().toString();
                String Pass = ed2.getText().toString();
                //try catch data
                if(usename.length() > 0 && Pass.length() > 0)
                {
                    Event = 1;
                }
                else if(usename.length() > 0 && Pass.length() == 0)
                {
                    Event = 2;
                    btn2.setEnabled(true);
                    DialogAlert("Nhập thiếu pass kìa");
                }
                else if(usename.length() == 0 && Pass.length() > 0)
                {
                    Event = 3;
                    btn2.setEnabled(true);
                    DialogAlert("Nhập thiếu use case kìa");
                }
                else if(usename.length() == 0 && Pass.length() == 0)
                {
                    Event = 4;
                    btn2.setEnabled(true);
                    DialogAlert("Rỗng");
                }
                switch (Event)
                {
                    case 1:
                        usenameAndPassYes(usename , Pass);
                        break;
                    case 2:
                        usenameYesAndPassNo(usename , Pass);
                        break;
                    case 3:
                        usenameNoAndPassYesss(usename , Pass);
                        break;
                    case 4:
                        usenameNoAndPassNo(usename , Pass);
                        break;

                }
            }
        });
        // event dialog
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Bạn muốn đăng ký tài khoản mới à").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this , Main3Activity.class);
                        startActivityForResult(intent , SECONDARY);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alerts = alert.create();
                alerts.setTitle("Thông báo");
                alerts.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SECONDARY)
        {
            if(resultCode == RESULT_OK)
            {
                String kq1 = data.getStringExtra("usename");
                String kq2 = data.getStringExtra("pass");
                Usename = kq1;
                 Pass = kq2;
            }
        }
    }

    private void usenameAndPassYes(String usename , String Pass)
    {
          String usename2 = "tuanphan";
          String pass2 = "1234ABC";
          if(usename.equals(usename2) == true && Pass.equals(pass2) == true || usename.equals(Usename) == true && Pass.equals(Pass) == true )
          {
              Intent intent = new Intent(MainActivity.this ,Main2Activity.class);
              intent.putExtra("guidata" , ed1.getText().toString());
              startActivityForResult(intent , SECONDARY);

          }
          else
          {
              txt6.setText("Chúng tôi nhận ra usename và pass sai");
          }
    }
    private void usenameYesAndPassNo(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == true && Pass.equals(pass2) == false || usename.equals(Usename) == true && Pass.equals(Pass) == true )
            {
                txt6.setText("Mat khẩu bạn nhập sai");
            }
            else
            {
                txt6.setText("Mat khẩu bạn nhập sai");
            }

    }
    private void usenameNoAndPassYesss(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == false && Pass.equals(pass2) == true || usename.equals(Usename) == true && Pass.equals(Pass) == true )
            {
                txt6.setText("Nhap use name nhập sai");
            }
            else
            {
                txt6.setText("Nhap use name sai");
            }
    }
    private void usenameNoAndPassNo(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == false && Pass.equals(pass2) == false || usename.equals(Usename) == true && Pass.equals(Pass) == true )
            {
                txt6.setText("cả mật khẩi và tài khoản chưa nhập");
            }
            else
            {
                txt6.setText("cả mật khẩi và tài khoản chưa nhập");
            }
    }
    // dialog
    private void DialogAlert(String character)
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setMessage(""+character);
        alert.show();
    }

}

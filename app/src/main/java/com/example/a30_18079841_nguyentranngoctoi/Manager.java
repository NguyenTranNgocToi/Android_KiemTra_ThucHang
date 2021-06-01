package com.example.a30_18079841_nguyentranngoctoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Manager extends AppCompatActivity {
    Button btnshow, btnadd,btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);
        btnshow=findViewById(R.id.btn_show_manager);
        btnadd=findViewById(R.id.btn_add_manager);
        btnlogout=findViewById(R.id.btn_logout_manager);

        btnshow.setOnClickListener(view->{
            startActivity(new Intent(Manager.this,MainActivity.class));
        });
        btnadd.setOnClickListener(view->{
            startActivity(new Intent(Manager.this,AddEmployee.class));
        });
        btnlogout.setOnClickListener(view->{
            startActivity(new Intent(Manager.this,Login.class));
        });
    }
}

package com.example.a30_18079841_nguyentranngoctoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnback;
    RecyclerView rcv;
    CustomAdapter adt;
    ArrayList<Emloyee> emloyees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnback = findViewById(R.id.btn_back_main);
        rcv = findViewById(R.id.recyclerView);

        emloyees = new ArrayList<>();
        Emloyee emloyee = new Emloyee("1","toi",1);
        emloyees.add(emloyee);
        emloyees.add(new Emloyee("1","toi",1));
        adt = new CustomAdapter(emloyees);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
//                rcvperson.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(layoutManager);
    }
}
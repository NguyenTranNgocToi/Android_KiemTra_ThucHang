package com.example.a30_18079841_nguyentranngoctoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "https://60ab127c5a4de40017cc94ba.mockapi.io/";
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
        getData(url);
        adt = new CustomAdapter(emloyees);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
//                rcvperson.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(layoutManager);

        btnback.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Manager.class));
        });


    }

    private void getData(String url) {
        JsonArrayRequest request = new JsonArrayRequest(url + "employee", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = (JSONObject) response.get(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");
                        int age = obj.getInt("age");
                        String depart = obj.getString("department");
                        Emloyee emloyee = new Emloyee(id, name, age,depart);
                        emloyees.add(emloyee);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adt = new CustomAdapter(emloyees);
                rcv.setHasFixedSize(true);
                rcv.setAdapter(adt);
//                rcvperson.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                LinearLayoutManager layoutManager = new LinearLayoutManager(
                        MainActivity.this, LinearLayoutManager.VERTICAL, false);
                rcv.setLayoutManager(layoutManager);

                btnback.setOnClickListener(view -> {
                    startActivity(new Intent(MainActivity.this, Manager.class));
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



}

package com.example.a30_18079841_nguyentranngoctoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Delete extends AppCompatActivity {
    Button btnyes,btnno;
    String id="";
    String url = "https://60ab127c5a4de40017cc94ba.mockapi.io/";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        btnyes = findViewById(R.id.btnyes_delete);
        btnno=findViewById(R.id.btnno_delete);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            id = bd.getString("id");
        }
        btnno.setOnClickListener(view->{
            startActivity(new Intent(Delete.this, MainActivity.class));
        });
        btnyes.setOnClickListener(view->{
            delete(url);
        });






    }

    private void delete(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url + "employee/" +
               id.toString().trim(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Delete.this, "Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Delete.this, MainActivity.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Delete.this, "Error to Data", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

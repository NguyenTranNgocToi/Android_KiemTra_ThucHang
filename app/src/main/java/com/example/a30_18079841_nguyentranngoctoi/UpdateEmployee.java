package com.example.a30_18079841_nguyentranngoctoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateEmployee extends AppCompatActivity {
    String url = "https://60ab127c5a4de40017cc94ba.mockapi.io/";
    Button btnSave,btnBack;
    EditText edname,edage,eddepart;
    String id="",name="",age="",depart="";


//    Bundle bd = getIntent().getExtras();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_emplayee);

        btnBack = findViewById(R.id.btn_back_up);
        btnSave = findViewById(R.id.btn_save_up);

        edname = findViewById(R.id.ed_name_up);
        edage = findViewById(R.id.ed_age_up);
        eddepart = findViewById(R.id.ed_depart_up);


        Bundle bd = getIntent().getExtras();

        if (bd != null) {
            id = bd.getString("id");
            name=bd.getString("name");
            age=bd.getString("age");
            depart=bd.getString("department");

            edname.setText(name);
            edage.setText(age);
            eddepart.setText(depart);

        }

        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(UpdateEmployee.this, MainActivity.class));
        });
        btnSave.setOnClickListener(view -> {
//            Toast.makeText(UpdateEmployee.this, id +name+age+depart, Toast.LENGTH_SHORT).show();
            put(url);
        });
    }
    private void put(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url + "employee/"
                + id.toString().trim(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(UpdateEmployee.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateEmployee.this, "Error to Data", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();

                params.put("name",edname.getText().toString().trim());
                params.put("age",edage.getText().toString().trim());
                params.put("department",eddepart.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}

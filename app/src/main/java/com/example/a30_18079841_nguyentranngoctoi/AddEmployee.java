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

public class AddEmployee extends AppCompatActivity {
    String url = "https://60ab127c5a4de40017cc94ba.mockapi.io/";
    EditText edName,eddepart,edage;
    Button btnCreate,btnBack;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee);


        edName = findViewById(R.id.ed_name_up);
        eddepart=findViewById(R.id.ed_depart_add);
        edage =findViewById(R.id.ed_age_add);

        btnCreate=findViewById(R.id.btn_create_add);
        btnBack=findViewById(R.id.btn_back_add);


        btnCreate.setOnClickListener(view->{
            post(url);
        });
        btnBack.setOnClickListener(view->{
            startActivity(new Intent(AddEmployee.this, Manager.class));
        });


    }

    private void post(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url + "employee", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddEmployee.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddEmployee.this, "Error to Data", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("id","1000");
                params.put("name", edName.getText().toString().trim());
                params.put("age",  "10");
                params.put("department", eddepart.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

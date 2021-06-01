package com.example.a30_18079841_nguyentranngoctoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    //user nguyentoi@gmail.com
    //pass 123456
    Button btnlogin;

    EditText edEmail,edPassWord;
    TextView tvExit;
    //tao mot doi tuong Firebase Auth
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnlogin =findViewById(R.id.btnLogin);
        edEmail = findViewById(R.id.edemail_login);
        edPassWord = findViewById(R.id.ed_pass_login);
        tvExit = findViewById(R.id.tv_exit_login);
        mAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(view->{
            loginUser();
        });
        tvExit.setOnClickListener(view->{

        });
    }

    private void loginUser() {
        String email = edEmail.getText().toString();
        String passWord = edPassWord.getText().toString();
        if(email.equalsIgnoreCase(null)){
            Toast.makeText(Login.this,"Chua nhap email",Toast.LENGTH_SHORT).show();
        }else if(passWord.equalsIgnoreCase(null)){
            Toast.makeText(Login.this,"Chua nhap mat khau",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,Manager.class));
                    }   else {
                        Toast.makeText(Login.this,"Sai tên tài khoản hoặc mật khẩu",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

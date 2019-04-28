package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etusername);
        etPassword = findViewById(R.id.etPassword);
        tvSignup= findViewById(R.id.tvSignUp);
        btnLogin= findViewById(R.id.btnLogin);

        tvSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnLogin){
            checkUser();

        }
        else if(v.getId() == R.id.tvSignUp){

            Intent i = new Intent(getApplicationContext(), SignUp.class);
            startActivity(i);
        }
    }

    private void checkUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        if(username.equals(etUsername.getText().toString()) ||
        password.equals(etPassword.getText().toString())){
            Toast.makeText(this, "Successful",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Failed",Toast.LENGTH_LONG).show();
        }
    }
}

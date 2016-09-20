package com.example.rkilaparthi.examplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rkilaparthi on 9/13/2016.
 */
public class Register extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String PWD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText userName = (EditText) findViewById(R.id.edt_Rname);
        final EditText password = (EditText) findViewById(R.id.edt_Rpassword);
        final EditText confirmPassword = (EditText) findViewById(R.id.edt_RRepassword);
        final EditText email = (EditText) findViewById(R.id.edt_email);
        final EditText mobile = (EditText) findViewById(R.id.edt_Rmobile);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newConfirmPassword = confirmPassword.getText().toString();
                String newEmail = email.getText().toString();
                String newMobile = mobile.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(NAME, newUser);
                editor.putString(PWD, newPassword);
                editor.commit();
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
                Register.this.finish();
            }
        });
    }
}

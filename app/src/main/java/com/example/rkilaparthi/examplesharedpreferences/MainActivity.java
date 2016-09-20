package com.example.rkilaparthi.examplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText lName;
    private EditText lPassword;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        lName = (EditText) findViewById(R.id.edt_userName);
        lPassword = (EditText) findViewById(R.id.edt_password);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUser = lName.getText().toString();
                String password = lPassword.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Register.NAME, newUser);
                editor.putString(Register.PWD, password);
                editor.commit();
                Intent displayScreen = new Intent(MainActivity.this, DispalyScreen.class);
                startActivity(displayScreen);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(MainActivity.this, Register.class);
                startActivity(register);
                MainActivity.this.finish();
            }
        });

    }

    @Override
    protected void onResume() {
        String name = preferences.getString(Register.NAME, "");
        String pwd = preferences.getString(Register.PWD, "");
        if (lName != null && lPassword != null) {
            lName.setText(name);
            lPassword.setText(pwd);
        }
        super.onResume();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {

            if (!AppState.getSingleInstance().isLoggingOut()) {
                finish();
            } else {
                AppState.getSingleInstance().setLoggingOut(false);
                super.onActivityResult(requestCode, resultCode, data);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }
}

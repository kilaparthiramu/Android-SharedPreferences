package com.example.rkilaparthi.examplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rkilaparthi on 9/13/2016.
 */
public class DispalyScreen extends AppCompatActivity {
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
     Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        SharedPreferences preferences=getSharedPreferences("MYPREF",MODE_PRIVATE);
        String name=preferences.getString(Register.NAME,"");
        String pwd=preferences.getString(Register.PWD,"");
        TextView displayInfo=(TextView)findViewById(R.id.txt_profile);
        displayInfo.setText(name +"\n" +pwd);
        radioGroup1 = (RadioGroup) findViewById(R.id.rg_1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg_2);
        radioGroup3 = (RadioGroup) findViewById(R.id.rg_3);
        btnDisplay = (Button) findViewById(R.id.btn);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                int selectedId2= radioGroup2.getCheckedRadioButtonId();
                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                radioButton1 = (RadioButton) findViewById(selectedId1);
                radioButton2 = (RadioButton) findViewById(selectedId2);
                radioButton3 = (RadioButton) findViewById(selectedId3);
                Intent i=new Intent(DispalyScreen.this,Sample.class);
                i.putExtra("group1",radioButton1.getText().toString());
                i.putExtra("group2",radioButton2.getText().toString());
                i.putExtra("group3",radioButton3.getText().toString());
                startActivity(i);
            }
        });
    }
}

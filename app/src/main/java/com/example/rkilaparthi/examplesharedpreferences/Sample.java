package com.example.rkilaparthi.examplesharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rkilaparthi on 9/14/2016.
 */
public class Sample extends Activity {
    TextView t4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        b1 = (Button) findViewById(R.id.logout);
        t4 = (TextView) findViewById(R.id.tv_result);
        Intent i = getIntent();
        String s1 = i.getStringExtra("group1");
        String s2 = i.getStringExtra("group2");
        String s3 = i.getStringExtra("group3");
        t4.setText("your text is:"+"\n" + s1 + "\n" + s2 + "\n" + s3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SharedPreferences myPrefs = getSharedPreferences("MYPREF",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.clear();
            editor.commit();
            AppState.getSingleInstance().setLoggingOut(true);
            Log.d("TAG", "Now log out and start the activity login");
                Intent intent = new Intent(Sample.this,
                        MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, 2);

            }
        });
    }
}

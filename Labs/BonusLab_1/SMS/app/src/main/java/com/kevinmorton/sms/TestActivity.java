package com.kevinmorton.sms;

/**
 * Created by KevinMortonMacPro on 12/2/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends Activity {
    private String memberFieldString;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        Bundle extras = getIntent().getExtras();
        String userName;
        String message;
        if (extras != null) {
            userName = extras.getString("num");
            Log.d("YourActivity", "OK!");
            message = extras.getString("content");

            EditText ct = (EditText) findViewById(R.id.content);
            TextView ct2 = (TextView) findViewById(R.id.content2);

            ct.setText(userName);
            ct2.setText(message);
        }
    }
}

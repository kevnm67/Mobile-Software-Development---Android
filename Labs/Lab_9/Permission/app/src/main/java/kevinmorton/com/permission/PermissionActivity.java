package kevinmorton.com.permission;

import android.content.Context;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;

import android.view.Menu;

import android.view.MenuItem;

import android.view.View;

import android.widget.Button;

import android.content.Intent;

public class PermissionActivity extends ActionBarActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        final Context context = this;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final Button interb = (Button) findViewById(R.id.interb);

        // Internet Button listener

        interb.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Start Internet Activity

                Intent intent = new Intent(context, InternetActivity.class);

                startActivity(intent);

            }

        });

        final Button smsb = (Button) findViewById(R.id.smsb);

        // SMS Button listener

        smsb.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Start SMS Activity

                Intent intent = new Intent(context, SMSActivity.class);

                startActivity(intent);

            }

        });

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_permission, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long

        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {

            return true;

        }

        return super.onOptionsItemSelected(item);

    }

}
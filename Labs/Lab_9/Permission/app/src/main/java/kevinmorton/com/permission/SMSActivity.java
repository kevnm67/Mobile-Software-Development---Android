package kevinmorton.com.permission;

/**
 * Created by KevinMortonMacPro on 10/5/15.
 */

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class SMSActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);

        final Button send = (Button) findViewById(R.id.send);
        final EditText text = (EditText) findViewById(R.id.Text);
        final EditText addr = (EditText) findViewById(R.id.addr);
        send.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // get address and text
                String maddr = addr.getText().toString();
                String mtext = text.getText().toString();
                SmsManager smsmanager = SmsManager.getDefault();
                // send message
                if (maddr.trim().length() != 0 && mtext.trim().length() != 0) {
                    try {
                        PendingIntent pintent = PendingIntent.getBroadcast(
                                SMSActivity.this, 0, new Intent(), 0);
                        smsmanager.sendTextMessage(maddr, null, mtext, pintent,
                                null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(SMSActivity.this, "sending success",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SMSActivity.this,
                            "Enter Address and Message", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            ;
        });
    }
}
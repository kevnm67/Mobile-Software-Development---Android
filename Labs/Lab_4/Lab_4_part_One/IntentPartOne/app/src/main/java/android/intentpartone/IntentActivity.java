package android.intentpartone;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button invoke=(Button)findViewById(R.id.button1);


        invoke.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {

                Intent intent = new Intent(context, ActivityB.class);
                startActivity(intent);
            }
        });
    }
}
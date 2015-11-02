package com.kevinmorton.birthdaycontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends FragmentActivity {

    private final String LOG_TAG = AddActivity.class.getSimpleName();
    private TextView mNameTextView, mBirthdayTextView;
    private Button mButton;
    private ContentResolver mContentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        mNameTextView = (TextView) findViewById(R.id.friendName);
        mBirthdayTextView = (TextView) findViewById(R.id.friendBirthday);

        mContentResolver = AddActivity.this.getContentResolver();

        mButton = (Button) findViewById(R.id.saveButton);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isValid()) {
                    ContentValues values = new ContentValues();
                    values.put(FriendsContract.FriendsColumns.FRIENDS_NAME, mNameTextView.getText().toString());
                    values.put(FriendsContract.FriendsColumns.FRIENDS_BIRTHDAY, mBirthdayTextView.getText().toString());

                    Uri returned = mContentResolver.insert(FriendsContract.URI_TABLE, values);
                    Log.d(LOG_TAG, "record id returned is " + returned.toString());

                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Please check the text you entered and verify it's valid.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isValid() {
        if (mNameTextView.getText().toString().length() == 0 ||
                mBirthdayTextView.getText().toString().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean someDataEntered() {
        if (mNameTextView.getText().toString().length() > 0 ||
                mBirthdayTextView.getText().toString().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (someDataEntered()) {
            FriendsDialog dialog = new FriendsDialog();
            Bundle args = new Bundle();
            args.putString(FriendsDialog.DIALOG_TYPE, FriendsDialog.CONFIRM_EXIT);
            dialog.setArguments(args);
            dialog.show(getSupportFragmentManager(), "confirm-exit");
        } else {
            super.onBackPressed();
        }
    }
}

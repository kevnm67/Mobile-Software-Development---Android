package com.kevinmorton.birthdaycontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditActivity extends FragmentActivity {

    private final String LOG_TAG = EditActivity.class.getSimpleName();
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
        mContentResolver = EditActivity.this.getContentResolver();

        Intent intent = getIntent();
        final String _id = intent.getStringExtra(FriendsContract.FriendsColumns.FRIENDS_ID);
        String name = intent.getStringExtra(FriendsContract.FriendsColumns.FRIENDS_NAME);
        String birthday = intent.getStringExtra(FriendsContract.FriendsColumns.FRIENDS_BIRTHDAY);

        mNameTextView.setText(name);
        mBirthdayTextView.setText(birthday);

        mButton = (Button) findViewById(R.id.saveButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put(FriendsContract.FriendsColumns.FRIENDS_NAME, mNameTextView.getText().toString());
                values.put(FriendsContract.FriendsColumns.FRIENDS_BIRTHDAY, mBirthdayTextView.getText().toString());
                Uri uri = FriendsContract.Friends.buildFriendUri(_id);
                int recordsUpdated = mContentResolver.update(uri, values, null, null);
                Log.d(LOG_TAG, "number of records update = " + recordsUpdated);
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return true;
    }
}

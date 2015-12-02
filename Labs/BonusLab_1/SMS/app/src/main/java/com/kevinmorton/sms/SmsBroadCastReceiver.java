package com.kevinmorton.sms;


import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class SmsBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        //Specify the bundle to get object based on SMS protocol "pdus"
        Object[] object = (Object[]) bundle.get("pdus");
        SmsMessage sms[] = new SmsMessage[object.length];

        for (int i = 0; i < object.length; i++) {
            sms[i] = SmsMessage.createFromPdu((byte[]) object[i]);

            //retrieve the contacts based on the provided phone number
            int resultNum = retrieveContactRecord(
                    sms[i].getDisplayOriginatingAddress(), context);
            //if the provided phone number is not found in contact list
            if (resultNum == 0) {

                //abort the broadcast
                abortBroadcast();

                //show an alert when message is filtered
                Toast.makeText(
                        context,
                        "Message from: " + sms[i].getDisplayOriginatingAddress() + " is filtered!"
                                + " Content is:" + sms[i].getDisplayMessageBody(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    //retrieve the number of matches from the contact list with the provided phone numer
    public static int retrieveContactRecord(String phoneNo, Context context) {
        int result = 0;
        try {
            Uri uri = Uri.withAppendedPath(
                    ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                    Uri.encode(phoneNo));
            String[] projection = new String[]{
                    ContactsContract.PhoneLookup._ID,
                    ContactsContract.PhoneLookup.DISPLAY_NAME};

            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = ContactsContract.PhoneLookup.DISPLAY_NAME
                    + " COLLATE LOCALIZED ASC";

            ContentResolver cr = context.getContentResolver();
            if (cr != null) {

                Cursor resultCur = cr.query(uri, projection, selection,
                        selectionArgs, sortOrder);

                if (resultCur != null) {

                    while (resultCur.moveToNext()) {
                        result++;
                    }
                    resultCur.close();
                }

            }
        } catch (Exception sfg) {
            Log.d("Error", "Error in loadContactRecord : "
                    + sfg.getMessage().toString());
        }
        return result;

    }

}

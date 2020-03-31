package com.example.intentpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SimpleSMSReceiver extends BroadcastReceiver {
    private static String TAG = "SimpleSMSReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: called");

        SmsMessage[] messages = parseMessage(intent.getExtras());

        if (messages.length > 0) {
            String content = messages[0].getMessageBody().toString();
            Log.d(TAG, "onReceive: " + content);
        }
    }

    private SmsMessage[] parseMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for (int i = 0; i < objs.length; i++) {
            String format = bundle.getString("format");
            messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
        }

        return messages;
    }
}

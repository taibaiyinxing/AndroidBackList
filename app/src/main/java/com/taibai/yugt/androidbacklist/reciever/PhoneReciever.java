package com.taibai.yugt.androidbacklist.reciever;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by yugt on 16/6/6.
 */
public class PhoneReciever extends BroadcastReceiver{

    private final static String TAG = "PhoneReciever";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            Toast.makeText(context,"去电",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"来电",Toast.LENGTH_SHORT).show();
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            switch (tm.getCallState()){
                case TelephonyManager.CALL_STATE_RINGING://响铃，来电

                    break;
                case TelephonyManager.CALL_STATE_IDLE://闲置，无任何状态

                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK://摘机，接听

                    break;
            }
        }
    }
}

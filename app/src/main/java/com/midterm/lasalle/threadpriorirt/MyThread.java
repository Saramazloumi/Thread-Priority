package com.midterm.lasalle.threadpriorirt;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

public class MyThread extends HandlerThread {

    private Handler handler;

    public MyThread(String name, int priority) {
        super(name, priority);
    }

    @Override
    protected void onLooperPrepared() {
        handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        for (int i = 0; i <= 5 ; i++) {
                            Log.d("MsgHandler", "Handling msg[" + msg.what+ "] with arg " + msg.arg1 + " obj " + msg.obj.toString() + "" + "i = " + i);
                            SystemClock.sleep(1000);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <= 5 ; i++) {
                            Log.d("MsgHandler", "Handling msg[" + msg.what+ "] with arg " + msg.arg1 + " obj " + msg.obj.toString() + "" + "i = " + i);
                            SystemClock.sleep(1000);
                        }
                        break;
                }
            }
        };
    }

    public Handler getHandler(){
        return handler;
    }
}

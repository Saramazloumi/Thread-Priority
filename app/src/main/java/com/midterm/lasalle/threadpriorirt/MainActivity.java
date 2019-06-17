package com.midterm.lasalle.threadpriorirt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyThread mainHandler = new MyThread("MainHandler", Process.THREAD_PRIORITY_LOWEST);
    private MyThread bgHandler = new MyThread("BGHandler", Process.THREAD_PRIORITY_AUDIO);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainHandler.start();
        bgHandler.start();
    }

    public void send(View view){
        Message messageOne = Message.obtain(mainHandler.getHandler());
        messageOne.what = 1;
        messageOne.arg1 = 143;
        messageOne.obj = "The first Message!";
        messageOne.sendToTarget();

        Message messageTwo = Message.obtain(bgHandler.getHandler());
        messageTwo.what = 2;
        messageTwo.arg1 = 153;
        messageTwo.obj = "The second Message!";
        messageTwo.sendToTarget();
    }
}

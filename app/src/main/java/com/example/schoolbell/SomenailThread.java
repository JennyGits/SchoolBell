package com.example.schoolbell;

import android.os.Handler;
import android.os.Message;

public class SomenailThread extends Thread{

    private Handler handler;

    public SomenailThread (Handler handler) { this.handler = handler; }

    @Override
    public void run() {
        Message msg = new Message();

        try {
            Thread.sleep(1500);
            msg.what = 1;
            handler.sendEmptyMessage(msg.what);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SomenailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somenail);

        SomenailThread somenailThread = new SomenailThread(handler);
        somenailThread.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                Intent intent = new Intent(SomenailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

}

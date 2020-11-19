package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class timetableActivity extends AppCompatActivity {

    //final TextView output = (TextView) findViewById(R.id.text_output);


    ArrayList<String> list;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        list = getIntent().getStringArrayListExtra("textList");
        if(list == null) list = new ArrayList<>();
        int p=0;

        for(int i=0;i<7;i++)
        {
            for(int j=0;j<5;j++)
            {
                int id = getResources().getIdentifier("table_"+i+"_"+j, "id", "com.example.schoolbell");
                text = findViewById(id);
                try {
                    text.setText(list.get(p));
                    Log.i("string", list.get(p));
                }catch(Exception e){
                    text.setText("");
                }
                p++;
            }
        }



        Button modBtn = findViewById(R.id.modifyBtn);
        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<7;i++)
                {
                    for (int j=0;j<5;j++)
                    {
                        int id = getResources().getIdentifier("table_"+i+"_"+j, "id", "com.example.schoolbell");
                        text = (TextView)findViewById(id);

                        if(text.getText() == null) {
                            list.add("");
                        }
                        else {
                            list.add(text.getText().toString());
                        }
                    }
                }



                Intent intent = new Intent(getApplicationContext(),ModifyTimetableActivity.class);
                intent.putExtra("textList", list);
                startActivity(intent);
            }
        });
    }
}
package com.example.schoolbell;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class timetableActivity extends AppCompatActivity {

    //final TextView output = (TextView) findViewById(R.id.text_output);

    private SharedPreferences mPreferences;
    private String SharedPrefFile = "com.example.schoolbell";


    //ArrayList<String> list;
    ArrayList<String> list;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);


        list = getStringArrayPref(this,"jenny");
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
                }catch(Exception e){
                    text.setText("");
                }
                p++;
            }
        }

        Button gobackBtn = findViewById(R.id.gobackBtn);
        gobackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



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
                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        list = data.getStringArrayListExtra("textList");
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
                }catch(Exception e){
                    text.setText("");
                }
                p++;
            }
        }

    }



    private ArrayList<String> getStringArrayPref(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}
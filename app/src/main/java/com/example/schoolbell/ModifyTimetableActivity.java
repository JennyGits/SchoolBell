package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ModifyTimetableActivity extends AppCompatActivity {

    Button modifyBtn;
    EditText text;

    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_timetable);

        modifyBtn=findViewById(R.id.modifyBtn);

        list = getIntent().getStringArrayListExtra("textList");

        int p=0;

        for(int i=0;i<7;i++)
        {
            for(int j=0;j<5;j++)
            {
                int id = getResources().getIdentifier("table2_"+i+"_"+j, "id", "com.example.schoolbell");
                text = findViewById(id);
                text.setText(list.get(p));
                p++;
            }
        }



        modifyBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                for(int i=0;i<7;i++)
                {
                    for (int j=0;j<5;j++)
                    {
                        int id = getResources().getIdentifier("table2_"+i+"_"+j, "id", "com.example.schoolbell");
                        text = findViewById(id);
                        list.add(text.getText().toString());
                    }
                }

                Intent intent = new Intent(getApplicationContext(),timetableActivity.class);
                intent.putExtra("textList", list);
                setStringArrayPref(ModifyTimetableActivity.this,"jenny",list);
                //startActivity(intent);
                setResult(1001,intent);
                finish();
            }
        });
    }

    private void setStringArrayPref(Context context, String key, ArrayList<String> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }
}
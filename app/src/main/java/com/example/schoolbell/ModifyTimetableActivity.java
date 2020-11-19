package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                startActivity(intent);


            }
        });
    }
}
package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        final Adapter adapter=new Adapter();

        adapter.addItem(new Card("온라인클래스"));
        adapter.addItem(new Card("구글클래스룸"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnCardItemClickListener() {
            @Override
            public void onItemClick(Adapter.ViewHolder holder, View view, int position) {
                Intent intent = new Intent(MainActivity.this,test_callender.class);
                startActivity(intent);
            }
        });
    }

}

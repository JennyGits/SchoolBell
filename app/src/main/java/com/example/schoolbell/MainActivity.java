package com.example.schoolbell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
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
        adapter.addItem(new Card("101클래스"));

        recyclerView.setAdapter(adapter);

        textView3=findViewById(R.id.textview3);

        adapter.setOnItemClickListener(new OnCardItemClickListener() {
            public void onClick(Adapter.ViewHolder holder, View view, int position) {
                Card item=adapter.getItem(position);
                textView3.setText(ClipData.Item.getTitle()+"의 아이템 선택");
            }
        });
    }

}

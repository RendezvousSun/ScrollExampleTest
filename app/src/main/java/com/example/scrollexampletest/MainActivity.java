package com.example.scrollexampletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout topBar = (LinearLayout) findViewById(R.id.topBar);
        ScrollChangeHeadView scrollChangeHeadView = (ScrollChangeHeadView) findViewById(R.id.scroll_change_head_view);

        scrollChangeHeadView.setTopBar(topBar);

        scrollChangeHeadView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText("+" + i);
                return textView;
            }
        });
    }
}
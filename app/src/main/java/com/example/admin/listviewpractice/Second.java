package com.example.admin.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {


    TextView tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        String name = getIntent().getStringExtra("name");
        String subject = getIntent().getStringExtra("subject");
        tv4.setText(name);
        tv5.setText(subject);
    }
}

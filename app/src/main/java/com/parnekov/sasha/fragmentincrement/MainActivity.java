package com.parnekov.sasha.fragmentincrement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentsUtil.getFragments(getIntent(), MainActivity.this);
    }
}

package com.thoughtworks.roompractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.thoughtworks.roompractice.R;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }
}
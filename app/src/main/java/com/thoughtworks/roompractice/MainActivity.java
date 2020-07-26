package com.thoughtworks.roompractice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.thoughtworks.roompractice.activities.SubmitActivity;
import com.thoughtworks.roompractice.activities.ViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.submit_activity).setOnClickListener(view -> createSubmitActivity());

        findViewById(R.id.view_activity).setOnClickListener(view -> createViewActivity());
    }

    private void createViewActivity() {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

    private void createSubmitActivity() {
        Intent intent = new Intent(this, SubmitActivity.class);
        startActivity(intent);
    }
}
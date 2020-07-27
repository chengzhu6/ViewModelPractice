package com.thoughtworks.roompractice.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.thoughtworks.roompractice.R;
import com.thoughtworks.roompractice.viewmodels.ArchViewModel;

public class ArchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch);
        TextView numberTextView = findViewById(R.id.number);
        ArchViewModel archViewModel = new ViewModelProvider(this).get(ArchViewModel.class);
        archViewModel.getIncreaseNumber().observe(this, integer -> numberTextView.setText(String.valueOf(integer)));

        findViewById(R.id.increase).setOnClickListener(view -> archViewModel.increase());
    }
}
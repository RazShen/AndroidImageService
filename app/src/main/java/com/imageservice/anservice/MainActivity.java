package com.imageservice.anservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        Intent intent = new Intent(this,AService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this,AService.class);
        System.out.println("Stopping service from main activity");
        stopService(intent);
    }
}

package com.imageservice.anservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * This method is used to set the view of the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method starts the service.
     * @param view
     */
    public void startService(View view) {
        Intent intent = new Intent(this,AService.class);
        startService(intent);
    }

    /**
     * This method stops the service
     * @param view
     */
    public void stopService(View view) {
        Intent intent = new Intent(this,AService.class);
        System.out.println("Stopping service from main activity");
        stopService(intent);
    }
}

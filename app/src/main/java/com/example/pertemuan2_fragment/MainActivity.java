package com.example.pertemuan2_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(getClass(MyWorker)).build();
        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view) {
                 WorkManager.getInstance().enqueueUniqueWork(
                 "Notifikasi", ExistingWorkPolicy.REPLACE, request);

            }

        });
    }
}
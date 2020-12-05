package com.example.lastclassdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_iv_search:

                break;
            case R.id.main_btn_edit:
               Intent intent= new Intent(this,RecordActivity.class);
               startActivity(intent);
                break;
            case R.id.main_btn_more:

                break;
        }
    }
}
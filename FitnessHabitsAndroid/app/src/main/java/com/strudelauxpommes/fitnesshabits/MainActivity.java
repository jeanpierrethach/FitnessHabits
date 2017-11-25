package com.strudelauxpommes.fitnesshabits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.strudelauxpommes.fitnesshabits.parameters.ParameterActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.strudelauxpommes.fitnesshabits.parameters.ProfileFragment;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void changeDate(MenuItem mi) {
        if (mi.getItemId() == R.id.datepicker) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.param){
            startActivity(new Intent(this, ParameterActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

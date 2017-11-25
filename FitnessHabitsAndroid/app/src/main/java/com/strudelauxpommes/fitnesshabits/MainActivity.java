package com.strudelauxpommes.fitnesshabits;

import android.content.Intent;
import android.app.DatePickerDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import com.strudelauxpommes.fitnesshabits.parameters.ParameterActivity;
import java.text.DateFormat;
import java.util.Calendar;
import com.strudelauxpommes.fitnesshabits.parameters.ProfileFragment;

import java.util.MissingFormatArgumentException;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem dateItem = menu.findItem(R.id.datepicker);
        viewModel.getDate().observe(this, new Observer<Calendar>() {
            @Override
            public void onChanged(@Nullable Calendar calendar) {
                if (calendar != null) {
                    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
                    dateItem.setTitle(dateFormat.format(calendar.getTime()));
                }
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.datepicker) {
            Calendar currentDate = viewModel.getDate().getValue();
            if (currentDate != null) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                return true;
            }
        }

        return false;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        viewModel.setDate(calendar);
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.param) {

            startActivity(new Intent(this, ParameterActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }*/
}

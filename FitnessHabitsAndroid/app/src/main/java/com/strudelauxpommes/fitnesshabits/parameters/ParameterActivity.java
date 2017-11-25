package com.strudelauxpommes.fitnesshabits.parameters;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.strudelauxpommes.fitnesshabits.R;

public class ParameterActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        mTabLayout = findViewById(R.id.tabLayout);

    }

}

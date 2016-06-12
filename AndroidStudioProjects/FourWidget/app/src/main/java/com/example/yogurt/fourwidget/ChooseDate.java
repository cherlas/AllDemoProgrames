package com.example.yogurt.fourwidget;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ChooseDate extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);

        button= (Button) findViewById(R.id.datapicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ChooseDate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String chooseDate=String.format("%d-%d-%d",year,monthOfYear,dayOfMonth);
                        System.out.println(chooseDate);
                        button.setText(chooseDate);
                    }
                },2016,3,22).show();
            }
        });
    }
}

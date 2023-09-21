package com.example.gosuslugi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_change);
        timeBtn = findViewById(R.id.time_change);
        applyBtn = findViewById(R.id.apply_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int startYear = 2023;
                int startMonth = 9;
                int startDay = 7;

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int day, int month, int year) {

                        timeTxt.setText(day + "-" + (month + 1) + "-" + year);

                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, startYear, startMonth, startDay);
                datePickerDialog.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean is24View = true;
                int hours = 10;
                int minutes = 30;

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int minute, int hour) {
                        timeTxt.setText(hours + ":" + minute);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, hours, minutes, is24View);
                timePickerDialog.show();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Запись")
                        .setMessage("Вы подтверждаете запись?")
                        .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Запись прошла успешно", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        })
                        .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                builder.show();
            }
        });

    }
}
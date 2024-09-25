package com.example.project2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvOutput, tvStudy, tvScreentime, tvSleep;
    Button btnBack, btnDone;
    SeekBar sbSleep, sbScreentime, sbStudy;
    CheckBox wakeup, fajr, eat, exercise, classes, zuhr, asr, maghrib, esha, bed;
    RadioGroup rgWater, rgBook;
    RadioButton waterChecked, bookChecked;
    RatingBar rate;
    LinearLayout loOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        wakeup=findViewById(R.id.cb_early);
        fajr=findViewById(R.id.cb_fajr);
        eat=findViewById(R.id.cb_eat);
        exercise=findViewById(R.id.cb_exercise);
        classes=findViewById(R.id.cb_classes);
        zuhr=findViewById(R.id.cb_zuhr);
        asr=findViewById(R.id.cb_asr);
        maghrib=findViewById(R.id.cb_maghrib);
        esha=findViewById(R.id.cb_esha);
        bed=findViewById(R.id.cb_bed);

        rgWater=findViewById(R.id.rg_water);
        rgBook=findViewById(R.id.rg_book);

        sbScreentime=findViewById(R.id.sb_screentime);
        sbSleep=findViewById(R.id.sb_sleep);
        sbStudy=findViewById(R.id.sb_study);

        rate=findViewById(R.id.ratingbar);

        tvOutput=findViewById(R.id.tv_output);
        tvScreentime=findViewById(R.id.tv_screentime);
        tvSleep=findViewById(R.id.tv_sleep);
        tvStudy=findViewById(R.id.tv_study);

        btnBack=findViewById(R.id.btn_back);
        btnDone=findViewById(R.id.btn_done);

        loOutput=findViewById(R.id.output_layout);


        sbStudy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvStudy.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbScreentime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvScreentime.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbSleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSleep.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if(wakeup.isChecked()){
                    String value = wakeup.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(fajr.isChecked()){
                    String value = fajr.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(eat.isChecked()){
                    String value = eat.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(exercise.isChecked()){
                    String value = exercise.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(classes.isChecked()){
                    String value = classes.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(zuhr.isChecked()){
                    String value = zuhr.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(asr.isChecked()){
                    String value = asr.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(maghrib.isChecked()){
                    String value = maghrib.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(esha.isChecked()){
                    String value = esha.getText().toString();
                    stringBuilder.append(value+"\n");
                }
                if(bed.isChecked()){
                    String value = bed.getText().toString();
                    stringBuilder.append(value+"\n");
                }

                int selectedId1 = rgBook.getCheckedRadioButtonId();
                bookChecked=findViewById(selectedId1);
                String book = bookChecked.getText().toString();
                stringBuilder.append("Read " +book+" of a book\n");

                int selectedId2 = rgWater.getCheckedRadioButtonId();
                waterChecked=findViewById(selectedId2);
                String water = waterChecked.getText().toString();
                stringBuilder.append("Drank " +water+" of water\n");

                String sleep = tvSleep.getText().toString();
                String study = tvStudy.getText().toString();
                String screenTime = tvScreentime.getText().toString();

                stringBuilder.append("Studied for " + study + " hours\n");
                stringBuilder.append("Screen Time " + screenTime + " hours\n");
                stringBuilder.append("Slept for " + sleep + " hours last night\n");

                tvOutput.setText(stringBuilder);
            }
        });




    }
}
package com.example.homework_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private TextView textView_sum;
    private EditText editText_info_name, editText_info_id;
    private String TAG = "main";
    private CheckBox checkBox_cofe, checkBox_icecream, checkBox_cake, checkBox_steak;
    private Button button_cancel, button_ok;
    private boolean flagHamster, flagrabbit, flagCat, flagcofe, flagicecream, flagcake, flagsteak;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Info");
        textView_sum = (TextView) findViewById(R.id.textView);

        editText_info_name = findViewById(R.id.editText_name);
        editText_info_id = findViewById(R.id.editText_id);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        Log.d(TAG, "onCreate: name = " + name);
        Log.d(TAG, "onCreate: id = " + id);

        editText_info_name.setText(intent.getStringExtra("name"));
        editText_info_id.setText(intent.getStringExtra("id"));

        checkBox_cofe = (CheckBox) findViewById(R.id.checkBox_cofe);
        checkBox_icecream = (CheckBox) findViewById(R.id.checkBox_icecream);
        checkBox_cake = (CheckBox) findViewById(R.id.checkBox_cake);
        checkBox_steak = (CheckBox) findViewById(R.id.checkBox_steak);

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_ok = (Button) findViewById(R.id.button_ok);

        flagHamster = false;
        flagrabbit = false;
        flagCat = false;

        flagcofe = false;
        flagicecream = false;
        flagcake = false;
        flagsteak = false;

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.radiobutonHamster:
                        flagHamster = true;
                        flagrabbit = false;
                        flagCat = false;
                        break;
                    case R.id.radiobutonrabbit:
                        flagHamster = false;
                        flagrabbit = true;
                        flagCat = false;
                        break;
                    case R.id.radiobutonCat:
                        flagHamster = false;
                        flagrabbit = false;
                        flagCat = true;
                        break;
                }
                Log.d(TAG, "onCheckedChanged: flagHamster = " + flagHamster);
                Log.d(TAG, "onCheckedChanged: flagrabbit = " + flagrabbit);
                Log.d(TAG, "onCheckedChanged: flagCat = " + flagCat);
            }
        });

        checkBox_cofe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flagcofe = isChecked;
                Log.d(TAG, "onCheckedChanged: flagcofe" + flagcofe);
            }
        });
        checkBox_cake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flagcake = isChecked;
                Log.d(TAG, "onCheckedChanged: flagcake" + flagcake);
            }
        });
        checkBox_icecream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flagicecream = isChecked;
                Log.d(TAG, "onCheckedChanged: flagicecream" + flagicecream);
            }
        });
        checkBox_steak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flagsteak = isChecked;
                Log.d(TAG, "onCheckedChanged: flagsteak" + flagsteak);
            }
        });
        button_cancel.setOnClickListener(new MyButton());
        button_ok.setOnClickListener(new MyButton());


    }

    private class MyButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int returnInfo = 10;
            switch (v.getId()) {
                case R.id.button_cancel:
                    radioGroup.clearCheck();
                    flagHamster = false;
                    flagrabbit = false;
                    flagCat = false;

                    checkBox_cofe.setChecked(false);
                    checkBox_icecream.setChecked(false);
                    checkBox_cake.setChecked(false);
                    checkBox_steak.setChecked(false);
                    flagcofe = false;
                    flagicecream = false;
                    flagcake = false;
                    flagsteak = false;

                    editText_info_name.setText("");
                    editText_info_id.setText("");
                    textView_sum.setText("");

                    break;
                case R.id.button_ok:
                    if(flagHamster){
                        textView_sum.append("你最喜歡的動物是 倉鼠 \n");
                    }else if(flagrabbit){
                        textView_sum.append("你最喜歡的動物是 兔子 \n");
                    }else if(flagCat){
                        textView_sum.append("你最喜歡的動物是 貓咪 \n");
                    }

                    textView_sum.append("你喜歡的食物有：");
                    if(flagcofe){
                        textView_sum.append("咖啡 ");
                    }
                    if(flagicecream){
                        textView_sum.append("冰淇淋 ");
                    }
                    if(flagcake){
                        textView_sum.append("蛋糕 ");
                    }
                    if(flagsteak){
                        textView_sum.append("牛排 ");
                    }
                    Intent intent = new Intent();
                    String data = textView_sum.getText().toString();
                    intent.putExtra("info",data);
                    setResult(returnInfo,intent);
                    finish();
                    break;
            }
        }
    }
}
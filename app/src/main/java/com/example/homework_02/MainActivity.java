package com.example.homework_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView editText_name, editText_id, textView_result;
    private Button button_cancel, button_ok;
    private Context context = this;
    private Intent intent;
    private final int RequestCode = 200;
    private String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_name = (TextView) findViewById(R.id.editText_name);
        editText_id = (TextView) findViewById(R.id.editText_id);
        textView_result = (TextView) findViewById(R.id.textView4);

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_ok = (Button) findViewById(R.id.button_ok);

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_name.setText("");
                editText_id.setText("");
                textView_result.setText("");
            }
        });

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_id.length() == 0 || editText_name.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please input id and name", Toast.LENGTH_SHORT).show();
                } else {
                    String id = editText_id.getText().toString();
                    String name = editText_name.getText().toString();

                    intent = new Intent(context, MainActivity2.class);
                    intent.putExtra("id", id);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, RequestCode);
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int returnInfo, Intent data) {
        super.onActivityResult(requestCode, returnInfo, data);
        Log.d(TAG, "onActivityResult: requestCode" + requestCode);
        Log.d(TAG, "onActivityResult: returnInfo" + returnInfo);
        if (requestCode == RequestCode) {
            String message = data.getStringExtra("info");
            textView_result.setText(message);

        }
    }
}
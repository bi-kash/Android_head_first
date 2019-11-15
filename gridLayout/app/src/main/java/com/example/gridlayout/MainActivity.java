package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1  = (EditText) findViewById(R.id.recipient);
        editText2  = (EditText) findViewById(R.id.message);


    }

    public void print(View view) {

        String s = editText1.getText().toString();
        editText2.setText(s);

    }

    public void ontoggleclicked(View view) {
        // get the state of the toggle button.
        boolean on = ((ToggleButton) view).isChecked();
        if(on){
            //on
            editText2.setText("on");

        }else{
            // off
            editText2.setText("off");
        }
    }

    public void onSwitchClicked(View view) {
        // is switch off?
        boolean on = ((Switch) view).isChecked();
        if(on){
            //on
            editText2.setText("switch is on");
        }
        else{
            //off
            editText2.setText("switch is off");

        }
    }
}

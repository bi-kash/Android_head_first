package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView txtView1;
    private EditText editText1;
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1  = (EditText) findViewById(R.id.message);
        txtView1 = (TextView) findViewById(R.id.txtView);

        // you can find which radio button is checked
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        if(id==-1) {
            //no radio button selected
        }else{
            RadioButton radioButton = (RadioButton) findViewById(id);
            // radioButton -> has reference to which radio button is clicked
        }
        // we can also give onclick to radio buttons but we don't need that now

        //spinner getselecteditem, first get ref using id
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String value = String.valueOf(spinner.getSelectedItemId()); //you now have the selected item, do whatever you want with that value



    }
    public void milk_chk(View view){
        //for checkbox

        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            txtView1.setText("Milk is checked");
        }else{
            txtView1.setText("Milk is Unchecked");
        }
    }

    public void print(View view) {

        String s = editText1.getText().toString();
        txtView1.setText(s);

    }

    public void ontoggleclicked(View view) {
        // get the state of the toggle button.
        boolean on = ((ToggleButton) view).isChecked();
        if(on){
            //on
            txtView1.setText("on");

        }else{
            // off
            txtView1.setText("off");
        }
    }

    public void onSwitchClicked(View view) {
        // is switch off?
        boolean on = ((Switch) view).isChecked();
        if(on){
            //on
            txtView1.setText("switch is on");
        }
        else{
            //off
            txtView1.setText("switch is off");

        }
    }


    public void img_btn_clicked(View view) {
        ++counter;
        // let's display a toast
        CharSequence text = "Hello, You clicked: " +counter +" times!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this,text,duration);
        toast.show();
    }
}

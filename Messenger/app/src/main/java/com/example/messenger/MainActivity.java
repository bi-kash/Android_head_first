package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText input = (EditText) findViewById(R.id.message);
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        String toSend = input.getText().toString();
        intent.putExtra("message", toSend);
        startActivity(intent);
    }
}

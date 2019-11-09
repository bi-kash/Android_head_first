package com.example.findbear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
//        brands.setText("Gottle of geer haha");
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        List<String> b = expert.getBrands(beerType);
        // build a string using the list values
        StringBuilder bFormat = new StringBuilder();
        for(String brand : b){
            bFormat.append(brand).append("\n");
        }
        //display the beers
        brands.setText(bFormat);

    }
}

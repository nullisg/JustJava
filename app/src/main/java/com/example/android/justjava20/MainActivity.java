package com.example.android.justjava20;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Coffee> coffees = new ArrayList<Coffee>();
    public static String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View summaryBar = findViewById(R.id.summary_bar);

        summaryBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSummary();
            }
        });
    }

    public void order_coffee(View view){
        switch(view.getId()){
            case R.id.black_coffee_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.black_coffee);
                break;
            case R.id.espresso_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.espresso);
                break;
            case R.id.cortado_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.cortado);
                break;
            case R.id.cappuccino_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.cappuccino);
                break;
            case R.id.latte_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.latte);
                break;
            case R.id.macchiato_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.macchiato);
                break;
            case R.id.flat_white_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.flat_white);
                break;
            case R.id.frappe_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.frappe);
                break;
            case R.id.mocha_btn:
                CoffeeOrderPop.coffeeType =  getString(R.string.mocha);
                break;

        }
        startActivity(new Intent(MainActivity.this, CoffeeOrderPop.class));

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){
            updateTotal();
        }
    }

    public void updateTotal(){
        TextView numCoffees = (TextView) findViewById(R.id.num_of_items_txt);
        numCoffees.setText(Integer.toString(coffees.size()));
    }

    private void showSummary(){
        TextView name = (TextView) findViewById(R.id.username);
        userName = name.getText().toString();

        startActivity(new Intent(MainActivity.this, SummaryPage.class));
    }
}

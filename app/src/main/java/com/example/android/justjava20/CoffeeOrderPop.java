package com.example.android.justjava20;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Greg on 05/02/2018.
 */

public class CoffeeOrderPop extends Activity {

    public static String coffeeType;
    private static final double BASE_COST = 5.00;
    private static final double CREAM_COST = 1.00;
    private static final double CHOCOLATE_COST = 1.00;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.coffee_order_popup);

        View mainLayout = findViewById(R.id.coffee_pop_layout);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.6), (int) (height*0.4));
    }

    public void addCoffee(View view){
        CheckBox cream = findViewById(R.id.cream_check);
        CheckBox chocolate = findViewById(R.id.chocolate_check);

        boolean creamChecked = cream.isChecked();
        boolean chocolateChecked = chocolate.isChecked();

        Coffee coffee = new Coffee(coffeeType, creamChecked, chocolateChecked);

        MainActivity.coffees.add(coffee);

        int numCoffees = MainActivity.coffees.size();

        finish();
    }

    public void cancel(View view){
        finish();
    }
}

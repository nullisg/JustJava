package com.example.android.justjava20;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Greg on 05/02/2018.
 */

public class SummaryPage extends Activity {

    private static final double BASE_PRICE = 5.00;
    private static final double CREAM_PRICE = 1.00;
    private static final double CHOCOLATE_PRICE = 2.00;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_page);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width, height);

        TextView totalPrice = (TextView) findViewById(R.id.total_price);
        totalPrice.setText(getTotalPrice());

        TextView orderSummary = (TextView) findViewById(R.id.order_summary_text);
        orderSummary.setText(getOrderSummary());


    }

    private String getOrderSummary(){
        StringBuilder str = new StringBuilder();

        str.append("Order for ");
        str.append(MainActivity.userName);
        str.append("\n\n");

        for(Coffee coffee : MainActivity.coffees){
            str.append("Coffee Type: ");
            str.append(coffee.getType());
            str.append("\n");
            str.append("Whipped Cream: ");
            str.append(coffee.hasWhippedCream() ? "Y" : "N");
            str.append("\n");
            str.append("Chocolate: ");
            str.append(coffee.hasChocolate() ? "Y" : "N");
            str.append("\n");
            str.append("Price: ");
            str.append(NumberFormat.getCurrencyInstance(Locale.UK).format(getCoffeePrice(coffee)));
            str.append("\n\n");
        }

        return str.toString();
    }

    private String getTotalPrice(){
        double total = 0.00;
        for (Coffee coffee : MainActivity.coffees){
            total += getCoffeePrice(coffee);
        }

        return getString(R.string.total) + " " + NumberFormat.getCurrencyInstance(Locale.UK).format(total);
    }

    private double getCoffeePrice(Coffee coffee){
        return BASE_PRICE + (coffee.hasWhippedCream() ? CREAM_PRICE : 0.00) + (coffee.hasChocolate() ? CHOCOLATE_PRICE : 0.00);
    }

    public void submitOrder(View view){

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email_address));
        email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        email.putExtra(Intent.EXTRA_TEXT, getOrderSummary());
        email.setType("message/rfc822");
        startActivity(email);
    }

    public void close(View view){
        finish();
    }
}

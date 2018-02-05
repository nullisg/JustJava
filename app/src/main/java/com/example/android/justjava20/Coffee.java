package com.example.android.justjava20;

/**
 * Created by Greg on 05/02/2018.
 */

public class Coffee {
    private String type;
    private boolean hasWhippedCream;
    private boolean hasChocolate;

    public Coffee(String type, boolean hasWhippedCream, boolean hasChocolate){
        setType(type);
        setHasWhippedCream(hasWhippedCream);
        setHasChocolate(hasChocolate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean hasWhippedCream() {
        return hasWhippedCream;
    }

    public void setHasWhippedCream(boolean hasWhippedCream) {
        this.hasWhippedCream = hasWhippedCream;
    }

    public boolean hasChocolate() {
        return hasChocolate;
    }

    public void setHasChocolate(boolean hasChocolate) {
        this.hasChocolate = hasChocolate;
    }
}

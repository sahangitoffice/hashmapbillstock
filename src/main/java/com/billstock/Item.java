package com.billstock;

/**
 * Created by hsenid on 10/17/16.
 */
public class Item {

    private String name;
    private double rate;
    private String code;
    private int quantity;


    public Item(String name, double rate, String code, int quantity){
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", rate=" + rate + ", code=" + code
                + ", quantity=" + quantity + "]";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

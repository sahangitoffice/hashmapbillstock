package com.billstock;

/**
 * Item class with Item Constructor
 * Created by hsenid on 10/17/16.
 */
public class Item {

    private String id;
    private String name;
    private double rate;
    private int code;
    private int quantity;

    /**
     *
     * Item constructor
     *
     */

    public Item(String id,String name, double rate, int code, int quantity){
        this.id=id;
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [id="+ getId() +",name=" + name + ", rate=" + rate + ", code=" + code
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

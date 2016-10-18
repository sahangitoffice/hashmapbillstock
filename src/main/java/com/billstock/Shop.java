package com.billstock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class with methods Add Item(), Search Item(), Display Item(), Issue Item()
 * Created by hsenid on 10/17/16.
 */
public class Shop {

    HashMap <String, Item> mapper = new HashMap<String, Item>();
    private Scanner sc = new Scanner(System.in);

    public void addItem() {

        //String message="invoked addItem method";

        String aCode;
        String aName;
        double aRate;
        int aQuantity;
        //Item foundItem;

        System.out.println("Enter Item code:");
        aCode = sc.next();

        //foundItem = search(aCode);

        //if (foundItem == null) {
            System.out.println("Item name : ");
            aName = sc.next();
            System.out.println("Rate : ");
            aRate = sc.nextDouble();
            System.out.println("Quantity : ");
            aQuantity = sc.nextInt();

            mapper.put(aCode, new Item(aName,aRate,aCode,aQuantity));

        }


    private Item search(String code) {
        //Iterator<Item> itr = mapper.iterator();

        Item item =mapper.get(code);


        if (item!=null){
            return item;
        }else{
            return null;
        }


    }


    public void display() {
        String letter;
        String code;
        //Item foundItem;
        //String itemName;

        System.out.println("To Display selceted Items press S or To Display all Items press A");
        letter=sc.next();

        if(letter.equals("S")){

            for (String name1: mapper.keySet()){

                String key =name1.toString();
                String value1 = mapper.get(name1).toString();

                System.out.println(key + " " + value1);

            }

        }else {

                System.out.println("ok");

        }
    }


    public void issueItem() {
        int numberOfItem;
        String code;
        Item foundItem;
        long total=0;

        label1:for (int i = 0; ; i++) {
            System.out.println("Enter Item code or to exit type exit");
            code = sc.next();

            if(code.equals("exit")){
                break label1;
            }

            foundItem = search(code);

            if (foundItem == null) {
                System.out.println("Item not found");
                return;
            }

            System.out.println("Number of Item : ");

            numberOfItem = sc.nextInt();

            if (numberOfItem > foundItem.getQuantity()) {
                System.out.println("\nRequired number of Items not in stock\n\n");
                return;
            } else {

                total+=numberOfItem * foundItem.getRate();

                System.out.println("\nCost of code num " + code +" of "+ numberOfItem + " items : rs. "
                        + numberOfItem * foundItem.getRate());
                foundItem.setQuantity(foundItem.getQuantity() - numberOfItem);

            }

        }

        System.out.println("----------------------------------------");
        System.out.println("\nTotal value is : rs " + total);
        System.out.println("----------------------------------------");

    }
}

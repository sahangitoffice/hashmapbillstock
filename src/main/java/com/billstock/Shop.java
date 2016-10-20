package com.billstock;

import java.util.*;

/**
 * Class with methods Add Item(), Search Item(), Display Item(), Issue Item()
 * Created by hsenid on 10/17/16.
 */
public class Shop {

    HashMap <Integer, Item> mapper = new HashMap<Integer, Item>();
    private Scanner sc = new Scanner(System.in);

    public void addItem() {

        Integer aCode;
        String aName;
        double aRate;
        int aQuantity;
        String id;
        String prefix = "xyz-";

        System.out.println("Enter Item code:");
        aCode = sc.nextInt();

        Item foundItem = search(aCode);

        if (foundItem == null) {

            System.out.println("Item name : ");
            aName = sc.next();
            System.out.println("Rate : ");
            aRate = sc.nextDouble();
            System.out.println("Quantity : ");
            aQuantity = sc.nextInt();


            id = autoId(prefix);

            mapper.put(aCode, new Item(id,aName, aRate, aCode, aQuantity));

        }else
        {

            System.out.println("Item exits and enter quantity : ");
            aQuantity = sc.nextInt();
            foundItem.setQuantity(foundItem.getQuantity() + aQuantity);
            System.out.println("Quantity updated");

        }
    }

    private Item search(int code) {

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

            for (int name1: mapper.keySet()){

                int key =name1;
                String value1 = mapper.get(name1).toString();

                System.out.println(key + " " + value1);

            }

        }else {

                System.out.println("no Items to Display");

        }
    }

    public void issueItem() {

        int numberOfItem;
        int code;
        Item foundItem;
        double total=0;
        String tmpCode;
        double paymentAmt;
        double balance;
        double finalBalance;

        label1:for (int i = 0; ; i++) {

            System.out.println("Enter Item code or to exit type exit");
            tmpCode = sc.next();

            if(tmpCode.equals("exit")){
                break label1;
            }

            code = Integer.parseInt(tmpCode);
            foundItem = search(code);

            if (foundItem == null) {
                System.out.println("Item not found ");
                return;
            }


            System.out.println("Number of Items : ");


            if (!sc.hasNextInt()){

                System.out.println("That's not a valid input!");
                //sc.next(); // this is important!

            }

            numberOfItem = sc.nextInt();

            /*
            try {
                numberOfItem = sc.nextInt();
            } catch (InputMismatchException e) {
               // throw new InputMismatchException("Enter valid input");
                System.out.println("please enter valid num of items");
            }
            */



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

        System.out.println("\nEnter Payment Amount");
        paymentAmt = sc.nextDouble();

        balance=paymentAmt-total;

        if((balance-(int)balance)!=0) {
            //System.out.println("decimal value is there");
            int decimal = (int)balance;
            double fractional = balance - decimal;

            if(fractional>=0.5){
                fractional=1;
            }else{
                fractional=0;
            }
            finalBalance=decimal+fractional;
            System.out.println("Balance = "+finalBalance);
        }
        else {
            finalBalance=balance;
            System.out.println("Balance = "+finalBalance);
        }
        System.out.println("----------------------------------------");

        double [] notesCoins = {1,2,5,10,20,50,100,1000,2000,5000};

        int x=0;
        String tempVar=",";
        label1:
        for(int i=0;i<notesCoins.length;i++){
            if(finalBalance<notesCoins[i]){
               tempVar+=notesCoins[i-1];
                finalBalance=finalBalance-notesCoins[i-1];
                i=0;
                if(finalBalance<=0){
                    break label1;
                }
            }
        }

        //System.out.println(tempVar);
        tempVar=tempVar.substring(1, tempVar.length()-1);
        //System.out.println(tempVar);
        String [] notes=tempVar.split("\\.");

        for (String y:notes) {
            System.out.println(y);
        }

        System.out.println("----------------------------------------");
    }


    public String autoId(String prefix){

        String id="";

        label1:
        for (int i = 1; i < 100; i++) {
            String Prefix = prefix + i;

            id = Prefix;

            if(mapper.isEmpty()){
                return id;
            }

            label2:
                for (int key : mapper.keySet()) {
                    Item item = mapper.get(key);

                    String value2 = item.getId();

                    if (value2.equals(id)) {

                        break label2;
                    }

                    if (!(value2.equals(id))) {
                        break label1;
                    }
                }
        }
        System.out.println("print id ="+id);
        return id;
    }

}

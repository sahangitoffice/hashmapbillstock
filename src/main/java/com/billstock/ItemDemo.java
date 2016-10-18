package com.billstock;

import java.util.Scanner;

/**
 * Class with main method
 * Select Add Items-Issue Items-Display Items
 * Created by hsenid on 10/17/16.
 */
public class ItemDemo {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        long code;
        char choice;
        Shop aShop = new Shop();
        Scanner sc = new Scanner(System.in);

        System.out.println("-----ITEM------");
        do {
            System.out.println("1. Add items to list");
            System.out.println("2. Issue item");
            System.out.println("3. Update item list");
            System.out.println("4. Display item details");
            System.out.println("5. Check price for a item");
            System.out.println("6. Exit");
            System.out.println("Choice:");
            choice = sc.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    aShop.addItem();
                    break;

                case '2':
                aShop.issueItem();
                break;

                //case '3':
                  //  aShop.updateStock();
                //aShop.issueItem();
                //break;

                case '4':
                aShop.display();
                break;

                //case '5':

                //System.out.println("Price of the Item is:"
                //  + aShop.checkPrice(inputCode()));

                case '6':
                    System.out.println("Thank you!\n");
                    break;
            }
        } while (choice != '6');
        sc.close();


    }

}

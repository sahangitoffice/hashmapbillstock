package com.billstocktest;

import com.billstock.Item;
import com.billstock.Shop;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Created by hsenid on 10/21/16.
 */
public class ShopTest {

    Shop newShop = new Shop();

    /**
     * method to test CheckPrice() method
     */

    @Test
    public void testCheckPrice() {

        String realAns=newShop.autoId("xyz");
        //Double expectedAns=0.0;

        boolean val = realAns.equals(null);

        assertFalse(realAns.equals(null));

        System.out.println(val);

        //assertEquals(realAns,expectedAns);

    }

    @Test
    public void testItem() {

        Item realAns=newShop.search(1);
        //Double expectedAns=0.0;

        //boolean val = realAns.equals("");

        assertNull(realAns);

       // System.out.println(val);

    }

    @Test
    public void testDisplay() {

        boolean realAns=newShop.display();
        //Double expectedAns=0.0;

        //boolean val = realAns.equals("");

        assertFalse(realAns==false);

        // System.out.println(val);

    }

}

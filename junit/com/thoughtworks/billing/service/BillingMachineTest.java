package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Category;
import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.bean.Packaging;
import com.thoughtworks.billing.util.PrettyBillPrinter;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class BillingMachineTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testSingleImportedItem() throws Exception {
        Biller biller = BillingMachine.getMachine();
        biller.buyItem(new Item("perfume", 27.99, Category.COSMETICS, Packaging.BOTTLE, true));
        Bill bill = biller.generateBill();

        assertEquals(32.19d, bill.getTotalPrice());
    }


    public void testSingleNonTaxableItem() throws Exception {
        Biller biller = BillingMachine.getMachine();
        biller.buyItem(new Item("Book", 10.00, Category.BOOKS, Packaging.NONE));
        Bill bill = biller.generateBill();
        assertEquals(10.00d, bill.getTotalPrice());
    }

    public void testLocalItems() throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Book", 12.49, Category.BOOKS));
        items.add(new Item("music CD", 14.99));
        items.add(new Item("chocolate bar", 0.85, Category.FOOD));

        Biller machine = BillingMachine.getMachine();
        machine.buyItems(items);

        Bill bill = machine.generateBill();

        PrettyBillPrinter.printBill(bill);

        assertEquals(1.50d, bill.getTotalTax());
        assertEquals(29.83, bill.getTotalPrice());
    }

    public void testImported() throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Chocolates", 10.00, Category.FOOD, Packaging.PACKET, true));
        items.add(new Item("perfume", 47.50, Category.OTHERS, Packaging.BOTTLE, true));

        Biller machine = BillingMachine.getMachine();
        machine.buyItems(items);

        Bill bill = machine.generateBill();

        PrettyBillPrinter.printBill(bill);

        //values different from the example provided
        assertEquals(7.65, bill.getTotalTax());
        assertEquals(65.15, bill.getTotalPrice());
    }

    public void testMixOfItems() throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("perfume", 27.99, Category.COSMETICS, Packaging.BOTTLE, true));
        items.add(new Item("perfume", 18.99, Category.COSMETICS, Packaging.BOTTLE));
        items.add(new Item("headache pills", 9.75, Category.MEDICINES, Packaging.PACKET));
        items.add(new Item("chocolates", 11.25, Category.FOOD, Packaging.BOX, true));

        Biller machine = BillingMachine.getMachine();
        machine.buyItems(items);

        Bill bill = machine.generateBill();

        PrettyBillPrinter.printBill(bill);

        assertEquals(6.70, bill.getTotalTax());
        assertEquals(74.68, bill.getTotalPrice());
    }
}

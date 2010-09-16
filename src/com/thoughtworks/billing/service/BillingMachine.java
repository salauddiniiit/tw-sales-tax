package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Bill;
import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.exception.BillerException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Billing machine is the point of sale.
 * All the items are bought using the machine and the bill can in turn be generated.
 * <p/>
 * TODO: On successful completion of transaction, the inventory should be informed to be updated.
 */
public class BillingMachine implements Biller {
    private List<Item> items = new ArrayList<Item>();


    /**
     * Buy the item.
     *
     * @param item item bought by the customer
     */
    public void buyItem(Item item) {
        items.add(item);
    }


    /**
     * Helper method to buy multiple items.
     *
     * @param items list of items bought by the customer
     */
    public void buyItems(List<Item> items) {
        for (Item item : items) {
            buyItem(item);
        }
    }


    /**
     * Bill generated for the items bought from the store.
     *
     * @return new bill
     * @throws BillerException
     */
    public Bill generateBill() throws BillerException {
        if (items.size() < 1) {
            throw new BillerException("No items bought");
        }
        Bill bill = new Bill(UUID.randomUUID().toString(), new ArrayList<Item>(items));
        items = new ArrayList<Item>();
        return bill;
    }
}

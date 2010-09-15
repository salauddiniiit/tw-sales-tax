package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Bill;
import com.thoughtworks.billing.bean.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BillingMachine implements Biller {
    final static BillingMachine machine = new BillingMachine();
    private List<Item> items = new ArrayList<Item>();

    private BillingMachine() {

    }

    //TODO: this can be made better. Why do we need a machine? Should state be managed here?
    //TODO: Create new exception
    static Biller getMachine() throws UnsupportedOperationException {
        if (machine.items.size() > 0) {
            throw new UnsupportedOperationException();
        }
        machine.items = new ArrayList<Item>();
        return machine;
    }


    public void buyItem(Item item) {
        items.add(item);
    }

    public void buyItems(List<Item> items) {
        for (Item item : items) {
            buyItem(item);
        }
    }

    public Bill generateBill() {
        Bill bill = new Bill(UUID.randomUUID().toString(), new ArrayList<Item>(items));
        items = new ArrayList<Item>();
        return bill;
    }
}

package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BillingMachine implements Biller {
    final static BillingMachine machine = new BillingMachine();
    private List<Item> items = new ArrayList<Item>();

    private BillingMachine() {

    }

    static Biller getMachine() {
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
        return new Bill(UUID.randomUUID().toString(), items);
    }
}

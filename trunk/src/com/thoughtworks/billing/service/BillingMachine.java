package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingMachine implements Biller {
    final static BillingMachine machine = new BillingMachine();
    Logger log = Logger.getLogger("BillingMachine");

    private List<Item> items = new ArrayList<Item>();

    private BillingMachine() {

    }

    static Biller getMachine() {
        machine.items = new ArrayList<Item>();
        return machine;
    }


    public void buyItem(Item item) {
        log.log(Level.FINE, "Buying item: " + item.getDescription());
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

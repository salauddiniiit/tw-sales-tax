package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.taxes.TaxCalculator;
import com.thoughtworks.billing.util.MoneyFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingMachine implements Bill, Biller {
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
        return this;
    }

    public List<Item> listSoldItems() {
        //return a defencive copy of the items
        return new ArrayList<Item>(items);
    }

    public double getTotalTax() {
        double tax = 0.0d;
        for (Item item : items) {
            tax += TaxCalculator.lookupTaxRate(item);
        }
        return MoneyFormatter.twoDecimalFormat(tax);
    }

    public double getTotalPrice() {
        double totalCost = 0.0d;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return MoneyFormatter.twoDecimalFormat(getTotalTax() + totalCost);
    }
}

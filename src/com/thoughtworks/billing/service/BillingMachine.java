package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.taxes.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingMachine implements Bill, Biller {
    final static BillingMachine machine = new BillingMachine();
    Logger log = Logger.getLogger("BillingMachine");

    private List<Item> items = new ArrayList<Item>();
    private TaxCalculator tax = new TaxCalculator();

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

    public BigDecimal getTotalTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Item item : items) {
            tax = tax.add(TaxCalculator.lookupTaxRate(item));
        }
        return TaxCalculator.getTaxInDecimal(tax, 2);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal price = new BigDecimal(0.0);
        for (Item item : items) {
            price = price.add(item.getPrice());
        }

        price = price.add(getTotalTax());
        return TaxCalculator.getTaxInDecimal(price, 2);
    }
}

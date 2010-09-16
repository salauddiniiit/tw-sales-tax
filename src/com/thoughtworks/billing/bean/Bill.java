package com.thoughtworks.billing.bean;

import com.thoughtworks.billing.taxes.TaxCalculator;
import com.thoughtworks.billing.util.MoneyFormatter;

import java.util.ArrayList;
import java.util.List;

//TODO: Fix quantity of items and its calculations

/**
 * Receipt of the items bought by a customer.
 */
public class Bill {
    List<Item> items = new ArrayList<Item>();
    String billNo = null;


    public Bill(String billNo, List<Item> items) {
        this.billNo = billNo;
        this.items = items;
    }


    public List<Item> listSoldItems() {
        return new ArrayList<Item>(items);
    }


    public double getTotalPrice() {
        double totalCost = 0.0d;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return MoneyFormatter.twoDecimalFormat(getTotalTax() + totalCost);
    }


    public double getPrice(Item item) {
        return MoneyFormatter.twoDecimalFormat(item.getCost() + getTax(item));
    }


    public double getTax(Item item) {
        return MoneyFormatter.twoDecimalFormat(TaxCalculator.applyTaxRules(item));
    }


    public double getTotalTax() {
        double tax = 0.0d;
        for (Item item : items) {
            tax += getTax(item);
        }
        return MoneyFormatter.twoDecimalFormat(tax);
    }
}

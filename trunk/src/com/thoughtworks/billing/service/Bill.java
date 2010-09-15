package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.taxes.TaxCalculator;
import com.thoughtworks.billing.util.MoneyFormatter;

import java.util.ArrayList;
import java.util.List;

//TODO: Fix quantity of items and its calculations
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

    public double getTotalTax() {
        double tax = 0.0d;
        for (Item item : items) {
            tax += TaxCalculator.applyTaxRules(item);
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

    public double getTax(Item item) {
        return MoneyFormatter.twoDecimalFormat(TaxCalculator.applyTaxRules(item));
    }

    public double getPrice(Item item) {
        return MoneyFormatter.twoDecimalFormat(item.getCost() + getTax(item));
    }
}

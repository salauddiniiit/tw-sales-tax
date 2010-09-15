package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Billable;

/**
 */
public class SalesTax extends Tax implements Billable {
    double TAX_RATE = 0.10d;
    final Billable item;

    SalesTax(Billable item) {
        this.item = item;
    }

    public double getCost() {
        return item.getCost();
    }

    @Override
    protected double getTaxRate() {
        return TAX_RATE;
    }

    public double getTax() {
        return item.getTax() + (item.getCost() * getTaxRate());
    }
}

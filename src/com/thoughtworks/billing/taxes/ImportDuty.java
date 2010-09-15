package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Billable;

/**
 * Import duty is applicable on any imported item.
 */
public class ImportDuty extends Tax implements Billable {
    double TAX_RATE = 0.05d;
    final private Billable item;

    ImportDuty(Billable item) {
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

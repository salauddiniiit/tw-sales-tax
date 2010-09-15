package com.thoughtworks.billing.taxes.taxtypes;

/**
 * Import duty is applicable on any imported item.
 */
public class ImportDuty extends Tax {
    final static double TAX_RATE = 0.05d;

    @Override
    public double getTaxRate() {
        return super.getTaxRate() + TAX_RATE;
    }
}

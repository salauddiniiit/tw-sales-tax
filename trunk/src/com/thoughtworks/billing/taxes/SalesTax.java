package com.thoughtworks.billing.taxes;

/**
 */
public class SalesTax extends Tax {
    final static double TAX_RATE = 0.10d;

    @Override
    protected double getTaxRate() {
        return super.getTaxRate() + TAX_RATE;
    }
}

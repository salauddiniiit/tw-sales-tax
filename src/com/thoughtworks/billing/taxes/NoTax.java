package com.thoughtworks.billing.taxes;

/**
 */
public class NoTax extends Tax {
    double TAX_RATE = 0.0d;


    @Override
    public double getTaxRate() {
        return super.getTaxRate() + TAX_RATE;
    }
}

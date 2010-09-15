package com.thoughtworks.billing.taxes;

/**
 */
public class SalesTax extends Tax {
    final static double TAX_RATE = 0.10d;

    public double lookupTaxRate() {
        return TAX_RATE;
    }
}

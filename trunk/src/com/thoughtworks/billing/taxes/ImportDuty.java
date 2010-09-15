package com.thoughtworks.billing.taxes;

/**
 * Import duty is applicable on any imported item.
 */
public class ImportDuty extends Tax {
    final private static double TAX_RATE = 0.05d;

    public double lookupTaxRate() {
        return TAX_RATE;
    }
}

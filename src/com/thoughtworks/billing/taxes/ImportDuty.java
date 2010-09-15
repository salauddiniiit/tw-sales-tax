package com.thoughtworks.billing.taxes;

import java.math.BigDecimal;

/**
 * Import duty is applicable on any imported item.
 */
public class ImportDuty extends Tax {
    final private static BigDecimal TAX_RATE = new BigDecimal(0.05);

    public BigDecimal lookupTaxRate() {
        return TAX_RATE;
    }
}

package com.thoughtworks.billing.taxes;

import java.math.BigDecimal;

/**
 */
public class SalesTax extends Tax {
    final static BigDecimal TAX_RATE = new BigDecimal(0.10);

    public BigDecimal lookupTaxRate() {
        return TAX_RATE;
    }
}

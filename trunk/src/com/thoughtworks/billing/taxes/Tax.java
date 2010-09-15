package com.thoughtworks.billing.taxes;

import java.math.BigDecimal;

public abstract class Tax {
    protected abstract BigDecimal lookupTaxRate();

    public final BigDecimal getTaxRate() {
        return lookupTaxRate();
    }
}

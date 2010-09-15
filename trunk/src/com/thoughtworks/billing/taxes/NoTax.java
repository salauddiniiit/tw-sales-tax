package com.thoughtworks.billing.taxes;

import java.math.BigDecimal;

public class NoTax extends TaxCalculator{
    final BigDecimal TAX_RATE = BigDecimal.ZERO;
}

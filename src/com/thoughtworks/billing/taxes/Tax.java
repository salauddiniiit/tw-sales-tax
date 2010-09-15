package com.thoughtworks.billing.taxes;

public abstract class Tax {
    protected abstract double lookupTaxRate();
}

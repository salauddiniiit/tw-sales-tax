package com.thoughtworks.billing.taxes;

import java.util.ArrayList;
import java.util.List;

public abstract class Tax {
    List<Tax> addedTaxes = new ArrayList<Tax>();


    public double getTaxRate() {
        double taxRate = 0.0d;
        for (Tax tax : addedTaxes) {
            taxRate += tax.getTaxRate();
        }
        return taxRate;
    }


    public void addTax(Tax tax) {
        addedTaxes.add(tax);
    }
}

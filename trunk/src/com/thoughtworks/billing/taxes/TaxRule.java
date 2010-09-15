package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.taxes.criteria.Criteria;
import com.thoughtworks.billing.taxes.taxtypes.Tax;

public class TaxRule {
    final Criteria<Item> criteria;
    final Tax tax;

    public TaxRule(Criteria<Item> criteria, Tax tax) {
        this.criteria = criteria;
        this.tax = tax;
    }

    public Tax getTax(Item item) throws UnsupportedOperationException {
        if (!isApplicable(item)) {
            throw new UnsupportedOperationException();
        }
        return tax;
    }

    public boolean isApplicable(Item item) {
        return criteria.matches(item);
    }
}

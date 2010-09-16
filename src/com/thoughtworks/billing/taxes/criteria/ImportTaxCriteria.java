package com.thoughtworks.billing.taxes.criteria;

import com.thoughtworks.billing.bean.Item;

public class ImportTaxCriteria implements Criteria<Item> {
    public boolean matches(Item item) {
        return item.isImported();
    }
}

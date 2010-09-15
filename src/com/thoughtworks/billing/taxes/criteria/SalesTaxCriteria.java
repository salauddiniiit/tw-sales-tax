package com.thoughtworks.billing.taxes.criteria;

import com.thoughtworks.billing.bean.Category;
import com.thoughtworks.billing.bean.Item;

public class SalesTaxCriteria implements Criteria<Item> {
    public boolean matches(Item item) {
        Category category = item.getCategory();
        return !category.equals(Category.FOOD) && !category.equals(Category.BOOKS) && !category.equals(Category.MEDICINES);
    }
}

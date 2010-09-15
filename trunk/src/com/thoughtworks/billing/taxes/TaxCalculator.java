package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Category;
import com.thoughtworks.billing.bean.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    public static BigDecimal lookupTaxRate(Item item) {
        Category category = item.getCategory();
        boolean imported = item.isImported();
        
        //TODO: create tax rules and create criteria to implement the rules. The rules can be used to do the taxation.
        //Use Tax decorator. Each taxation has its own rules
        if (imported) {
            item.addTax(new ImportDuty());
        }
        if (!category.equals(Category.FOOD) && !category.equals(Category.BOOKS) && !category.equals(Category.MEDICINES)) {
            item.addTax(new SalesTax());
        }

        BigDecimal priceAfterTax = item.getTaxRate().multiply(item.getPrice());
        return getTaxRoundOff(priceAfterTax, 2);
    }

    public static BigDecimal getTaxRoundOff(BigDecimal money, int decimal) {
        money = money.setScale(2, RoundingMode.HALF_DOWN);
        if (!money.divideAndRemainder(BigDecimal.ONE)[1].equals(BigDecimal.ZERO) && money.divideAndRemainder(BigDecimal.ONE)[1].compareTo(new BigDecimal(0.5)) > 0) {
            money = new BigDecimal(Math.ceil(money.doubleValue() * 20) / 20);
        }
        return getTaxInDecimal(money, decimal);
    }

    public static BigDecimal getTaxInDecimal(BigDecimal money, int decimal) {
        return money.setScale(decimal, RoundingMode.HALF_DOWN);
    }
}

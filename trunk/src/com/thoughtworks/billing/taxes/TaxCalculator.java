package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Billable;
import com.thoughtworks.billing.bean.Category;
import com.thoughtworks.billing.bean.Item;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;

public class TaxCalculator {
    final static BigDecimal TAX_FACTOR = new BigDecimal("0.05");

    public static double applyTaxRules(Item item) {
        Category category = item.getCategory();
        boolean imported = item.isImported();
        Billable taxable = item;

        //TODO: create taxRate rules and create criteria to implement the rules. The rules can be used to do the taxation.
        //Use Tax decorator. Each taxation has its own rules
        if (imported) {
            taxable = new ImportDuty(item);
        }
        if (!category.equals(Category.FOOD) && !category.equals(Category.BOOKS) && !category.equals(Category.MEDICINES)) {
            taxable = new SalesTax(taxable);
        }
        return getTaxRoundOff(taxable.getTax());
    }

    public static double getTaxRoundOff(double money) {
        BigDecimal value = new BigDecimal(money);
        value = value.divide(TAX_FACTOR);
        value = new BigDecimal(Math.ceil(value.doubleValue()));
        value = value.multiply(TAX_FACTOR);
        return getTaxInDecimal(value.doubleValue());
    }

    public static double getTaxInDecimal(double money) {
        Format format = new DecimalFormat("#.##");
        return Double.parseDouble(format.format(money));
        //return money.setScale(decimal, RoundingMode.HALF_DOWN);
    }
}

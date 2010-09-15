package com.thoughtworks.billing.taxes;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.taxes.criteria.ImportTaxCriteria;
import com.thoughtworks.billing.taxes.criteria.SalesTaxCriteria;
import com.thoughtworks.billing.taxes.taxtypes.ImportDuty;
import com.thoughtworks.billing.taxes.taxtypes.NoTax;
import com.thoughtworks.billing.taxes.taxtypes.SalesTax;
import com.thoughtworks.billing.taxes.taxtypes.Tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    final static BigDecimal TAX_FACTOR = new BigDecimal("0.05");
    static List<TaxRule> rules = new ArrayList<TaxRule>();

    static {
        rules.add(new TaxRule(new SalesTaxCriteria(), new SalesTax()));
        rules.add(new TaxRule(new ImportTaxCriteria(), new ImportDuty()));
    }

    public static double applyTaxRules(Item item) {
        Tax tax = new NoTax();
        for (TaxRule rule : rules) {
            if (rule.isApplicable(item)) {
                tax.addTax(rule.getTax(item));
            }
        }
        double price = tax.getTaxRate() * item.getCost();
        return getTaxRoundOff(price);
    }

    public static double getTaxRoundOff(double money) {
        BigDecimal value = new BigDecimal(money);
        value = value.divide(TAX_FACTOR);
        value = new BigDecimal(Math.ceil(value.doubleValue()));
        value = value.multiply(TAX_FACTOR);
        return value.doubleValue();
    }
}

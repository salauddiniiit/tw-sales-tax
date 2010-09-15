package com.thoughtworks.billing.bean;

import com.thoughtworks.billing.taxes.Tax;
import com.thoughtworks.billing.taxes.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Item {
    Category category = Category.OTHERS;
    Packaging packaging = Packaging.NONE;
    String description;
    BigDecimal price;
    boolean imported;

    public Item(String description, double price) {
        this(description, price, Category.OTHERS);
    }

    public Item(String description, double price, Category category) {
        this(description, price, category, Packaging.NONE);
    }

    public Item(String description, double price, Category category, Packaging packaging) {
        this(description, price, category, packaging, false);
    }


    public Item(String description, double price, Category category, Packaging packaging, boolean imported) {
        this.description = description;
        this.category = category;
        this.packaging = packaging;
        this.price = new BigDecimal(price);
        this.imported = imported;
    }
    
    public boolean isImported() {
        return imported;
    }

    public String getPackaging() {
        if (!packaging.equals(Packaging.NONE)) {
            return packaging.getDescription() + " of ";
        } else {
            return packaging.getDescription();
        }
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

/*
    public BigDecimal getTaxRate() {
        BigDecimal taxAggregate = BigDecimal.ZERO;
        for (Tax tax : taxes) {
            taxAggregate = taxAggregate.add(tax.getTaxRate());
        }
        return TaxCalculator.getTaxInDecimal(taxAggregate, 2);
    }

    public BigDecimal getTax() {
        return getTaxRate().multiply(getPrice());
    }
*/

    public BigDecimal getPrice() {
        return price;
    }

/*    public BigDecimal getPriceAfterTax() {
        return getTaxRate().multiply(getPrice()).add(getPrice());
    }*/
}

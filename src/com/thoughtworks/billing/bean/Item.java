package com.thoughtworks.billing.bean;

/**
 *
 */
public class Item {
    Category category = Category.OTHERS;
    Packaging packaging = Packaging.NONE;
    String description;
    double cost;
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


    public Item(String description, double cost, Category category, Packaging packaging, boolean imported) {
        this.description = description;
        this.category = category;
        this.packaging = packaging;
        this.cost = cost;
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


/*    public BigDecimal getTaxRate() {
        BigDecimal taxAggregate = BigDecimal.ZERO;
        for (Tax tax : taxes) {
            taxAggregate = taxAggregate.add(tax.getTaxRate());
        }
        return TaxCalculator.getTaxInDecimal(taxAggregate, 2);
    }

    public BigDecimal getTax() {
        return getTaxRate().multiply(getCost());
    }*/

    public double getCost() {
        return cost;
    }

/*    public BigDecimal getPrice() {
        return getTaxRate().multiply(this.getCost()).add(this.getCost());
    }*/
}

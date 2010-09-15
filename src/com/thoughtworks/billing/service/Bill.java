package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;

import java.math.BigDecimal;
import java.util.List;

public interface Bill {
    List<Item> listSoldItems();

    BigDecimal getTotalTax();

    BigDecimal getTotalPrice();

}

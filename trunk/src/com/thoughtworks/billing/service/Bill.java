package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Item;

import java.util.List;

public interface Bill {
    List<Item> listSoldItems();

    double getTotalTax();

    double getTotalPrice();

}

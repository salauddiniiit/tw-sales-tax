package com.thoughtworks.billing.service;

import com.thoughtworks.billing.bean.Bill;
import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.exception.BillerException;

import java.util.List;

public interface Biller {
    void buyItem(Item item);

    void buyItems(List<Item> items);

    Bill generateBill() throws BillerException;
}

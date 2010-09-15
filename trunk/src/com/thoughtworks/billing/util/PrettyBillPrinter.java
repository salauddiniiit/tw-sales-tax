package com.thoughtworks.billing.util;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.service.Bill;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;

public class PrettyBillPrinter {
    final static String print_format = "{0} {1} {2} {3} at {4}";
    final static Format moneyFormatter = new DecimalFormat("##.##");

    public static void printBill(Bill bill) {
        System.out.println("Input:");
        for (Item item : bill.listSoldItems()) {
            System.out.println(MessageFormat.format(print_format, "1",
                    item.isImported() ? "imported" : "", item.getPackaging(),
                    item.getDescription(), moneyFormatter.format(item.getCost())));
        }

        System.out.println("\nOutPut");
        for (Item item : bill.listSoldItems()) {
            System.out.println(MessageFormat.format(print_format, "1",
                    item.isImported() ? "imported" : "", item.getPackaging(),
                    item.getDescription(), moneyFormatter.format(bill.getPrice(item))));
        }

        System.out.println("Sales Taxes: " + moneyFormatter.format(bill.getTotalTax()));
        System.out.println("Total: " + moneyFormatter.format(bill.getTotalPrice()));
    }
}

package com.thoughtworks.billing.util;

import com.thoughtworks.billing.bean.Item;
import com.thoughtworks.billing.service.Bill;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;

public class PrettyBillPrinter {
    final static String print_format = "{0} {1} {2} {3} at {4}";
    final static NumberFormat format = new DecimalFormat("#.##");

    public static void printBill(Bill bill) {
        System.out.println("Input:");
        for (Item item : bill.listSoldItems()) {
            System.out.println(MessageFormat.format(print_format, "1",
                    item.isImported() ? "imported" : "", item.getPackaging(),
                    item.getDescription(), format.format(item.getCost())));
        }

        System.out.println("\nOutPut");
        for (Item item : bill.listSoldItems()) {
            System.out.println(MessageFormat.format(print_format, "1",
                    item.isImported() ? "imported" : "", item.getPackaging(),
                    item.getDescription(), format.format(bill.getTotalTax())));
        }

        System.out.println("Sales Taxes: " + format.format(bill.getTotalTax()));
        System.out.println("Total: " + format.format(bill.getTotalPrice()));
    }
}

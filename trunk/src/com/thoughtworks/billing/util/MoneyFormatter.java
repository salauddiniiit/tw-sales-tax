package com.thoughtworks.billing.util;

import java.text.DecimalFormat;
import java.text.Format;


public class MoneyFormatter {
    public static double twoDecimalFormat(double money) {
        Format decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(money));
    }
}

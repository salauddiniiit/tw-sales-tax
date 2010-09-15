package com.thoughtworks.billing.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyFormatter {
    public static double twoDecimalFormat(double money) {
        BigDecimal decimal = new BigDecimal(money);
        return decimal.setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }
}

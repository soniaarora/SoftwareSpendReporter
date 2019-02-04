package com.servicenow.assignment.utility;

import java.text.NumberFormat;
import java.util.Locale;

/***
 * Utilities class
 */
public class Utilities {
    private static final String INDENT_STRING = " ";

    public static String getIndentedString(String text, int indentationLevel) {
        if (indentationLevel == 0)
            return text;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indentationLevel; i++) {
            stringBuilder.append(INDENT_STRING);
        }
        stringBuilder.append(text);
        return stringBuilder.toString();
    }

    public static String getFormattedCurrency(double amount, Locale locale) {
        String money = NumberFormat.getCurrencyInstance(locale).format(amount);

        if (money.endsWith(".00")) {
            int centsIndex = money.lastIndexOf(".00");
            if (centsIndex != -1) {
                money = money.substring(0, centsIndex);
            }
        }
        return money;
    }
}

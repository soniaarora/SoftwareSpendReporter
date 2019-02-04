package com.servicenow.assignment.utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/*
 * Utilities test
 */
public class UtilitiesTest {

    @Test
    public void shouldAbleToConvertNumberToCurrency() {
        double amount = 99999.17;
        String actual = Utilities.getFormattedCurrency(amount, Locale.US);
        String expected = "$99,999.17";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldAbleToConvertNumberToCurrencyRemovingZeroCents() {
        double amount = 99999.00;
        String actual = Utilities.getFormattedCurrency(amount, Locale.US);
        String expected = "$99,999";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIndentText() {
      String text = "test";
      String expected = "  test";
      String actual = Utilities.getIndentedString(text, 2);

      Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIndentText() {
        String text = "test";
        String expected = "test";
        String actual = Utilities.getIndentedString(text, 0);

        Assert.assertEquals(expected, actual);
    }
}

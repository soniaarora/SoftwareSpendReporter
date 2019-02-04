package com.servicenow.assignment.softwarespend;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.servicenow.assignment.model.Product;
import com.servicenow.assignment.model.Transaction;
import com.servicenow.assignment.model.Vendor;
import com.servicenow.assignment.utility.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * Reporter class
 */
public class Reporter {

    public static void printReport(Map<String, Vendor> vendorMap) {
        for (Map.Entry<String, Vendor> vendorEntry : vendorMap.entrySet()) {
            List<String> list = new ArrayList();
            Vendor vendor = vendorEntry.getValue();
            double totalAmount = 0;

            for (Map.Entry<String, Product> productEntry : vendor.getProductMap().entrySet()) {
                Product product = productEntry.getValue();
                double amount = product.getTotalProductAmount();
                totalAmount += amount;
                String formattedCurrency = Utilities.getFormattedCurrency(amount, Locale.US);
                list.add(Utilities.getIndentedString(String.format("%s %s", product.getProductName(), formattedCurrency), 2));
            }
            list.add(0, Utilities.getIndentedString(String.format("%s %s", vendor.getVendorName(), Utilities.getFormattedCurrency(totalAmount, Locale.US)), 0));
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    public static Map<String, Vendor> generateVendorMap(String filePath) {
        Map<String, Vendor> vendorMap = new TreeMap();
        try {

            CSVReader csvReader = getCsvReader(filePath);

            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(nextRecord[0]);
                String vendorName = nextRecord[1];
                String productName = nextRecord[2];
                double amount = Double.parseDouble(nextRecord[3]);
                Vendor vendor = addVendor(vendorName, vendorMap);
                Product product = vendor.addProduct(productName);
                product.addTransaction(new Transaction(transactionDate, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendorMap;
    }

    public static CSVReader getCsvReader(String filePath) throws FileNotFoundException {

        FileReader filereader = new FileReader(filePath);
        return new CSVReaderBuilder(filereader).withSkipLines(1).build();
    }

    private static Vendor addVendor(String vendorName, Map<String, Vendor> vendorMap) {
        if (!vendorMap.containsKey(vendorName.toLowerCase())) {
            Vendor vendor = new Vendor(vendorName);
            vendorMap.put(vendorName.toLowerCase(), vendor);
            return vendor;
        }
        return vendorMap.get(vendorName.toLowerCase());
    }
}

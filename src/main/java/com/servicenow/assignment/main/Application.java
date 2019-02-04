package com.servicenow.assignment.main;

import com.servicenow.assignment.model.Vendor;
import com.servicenow.assignment.softwarespend.Reporter;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String filePath = args[0];
        Map<String, Vendor> vendorMap = Reporter.generateVendorMap(filePath);
        Reporter.printReport(vendorMap);
    }
}

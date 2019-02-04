package com.servicenow.assignment.softwarespend;

import com.opencsv.CSVReader;
import com.servicenow.assignment.model.Vendor;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Map;

public class ReporterTest {

    private final String fileContent = "1/28/2019,Microsoft,Office365,432854\n1/19/2019,Microsoft,Azure,5332\n1/28/2018,Microsoft,Office365,389777";
    private static  PrintStream sysOut;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterClass
    public static void revertStreams() {
        System.setOut(sysOut);
    }

    @Test
    public void shouldGenerateVendorMap() {
        mockCsvReader();

        Map<String, Vendor> vendorMap = Reporter.generateVendorMap("some file path...");

        Assert.assertEquals(1, vendorMap.size());
        Assert.assertEquals(2, vendorMap.get("microsoft").getProductMap().size());
    }

    @Test
    public void shouldAbleToPrintVendorMap(){

        mockCsvReader();

        Map<String, Vendor> vendorMap = Reporter.generateVendorMap("some file path...");

        Reporter.printReport(vendorMap);

        Assert.assertTrue(outContent.toString().contains("Microsoft $827,963"));
    }

    private void mockCsvReader() {

        new MockUp<Reporter>() {
            @Mock
            public CSVReader getCsvReader(String filePath) {
                return new CSVReader(new StringReader(fileContent));
            }
        };

    }
}

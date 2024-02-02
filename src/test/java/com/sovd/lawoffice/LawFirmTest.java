package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LawFirmTest {
    public void setup() {

    }

    @DataProvider(name = "validLawFirmData")
    public Object[][] validData() {
        return new Object[][]{
                {100, "Amarchand Co", "14th Ava street", "USA", "Charlotte"},
                {101, "Anand & Anand", "90 BROADWAY LANE", "USA", "cincinnati"},
        };
    }

    @Test(description = "Verify values to be inserted are valid", dataProvider = "validLawFirmData")
    public void verifyLawFirmValidTest(int lawFirmId, String lawFirmName, String address, String country, String city) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(lawFirmId);
        softAssert.assertNotNull(lawFirmName);
        softAssert.assertNotNull(address);
        softAssert.assertNotNull(country);
        softAssert.assertNotNull(city);
        softAssert.assertTrue(((lawFirmId >= 100) && (lawFirmId <= 200)), "Invalid Law Firm Id");
        softAssert.assertTrue(lawFirmName.matches("^[a-zA-Z&\\s-]+$"), "Invalid Law Firm Name");
        softAssert.assertTrue(address.matches("^[a-zA-Z0-9\\s-]+$"), "Invalid address");
        softAssert.assertTrue(country.matches("^[a-zA-Z\\s-]+$"), "Invalid country");
        softAssert.assertTrue(city.matches("^[a-zA-Z\\s-]+$"), "Invalid city");
        softAssert.assertAll();
    }

}

package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AttorneyTest {

    public void setup() {

    }

    @DataProvider(name = "validAttorneyData")
    public Object[][] validData() {
        return new Object[][]{
                {1001, "Nithya", "USA", "Dayton", 101},
                {1002, "Kanmani", "USA", "Charlotte", 100}
        };
    }

    @Test(description = "Verify if attorney Details are Valid", dataProvider = "validAttorneyData")
    public void verifyAttorneyDetailsAreValidTest(int attorneyId, String name, String country, String city, int lawFirmId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(attorneyId);
        softAssert.assertTrue(((attorneyId > 1000) && (attorneyId < 2000)), "Invalid Attorney Id");
        softAssert.assertNotNull(name);
        softAssert.assertTrue(name.matches("^[a-zA-Z&\\s-]+$"), "Invalid Attorney Name");
        softAssert.assertNotNull(country);
        softAssert.assertTrue(country.matches("^[a-zA-Z&\\s-]+$"), "Invalid Country Name");
        softAssert.assertNotNull(city);
        softAssert.assertTrue(city.matches("^[a-zA-Z&\\s-]+$"), "Invalid City Name");
        softAssert.assertAll();
    }

    @Test(description = "Verify if LawFirmId is valid", dataProvider = "validLawFirmData", dataProviderClass = LawFirmTest.class)
    public void verifyLawFirmIdTest(int lawFirmId, String lawFirmName, String address, String country, String city) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(lawFirmId);
        softAssert.assertTrue(((lawFirmId >= 100) && (lawFirmId <= 200)), "Invalid Law Firm Id");
        softAssert.assertAll();
    }

    @Test(description = "Verify if attorney Id valid", dataProvider = "validAttorneyData")
    public void verifyAttorneyAssociationBarTest(int attorneyId, String name, String country, String city, int lawFirmId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(attorneyId);
        softAssert.assertTrue(((attorneyId > 1000) && (attorneyId < 2000)), "Invalid Attorney Id");
        softAssert.assertAll();
    }

    @Test(description = "Verify if Association Bar Id is valid", dataProvider = "validAssociationBarData", dataProviderClass = AssociationBarTest.class)
    public void verifyAssociationBarIdTest(int associationBarId, String associationBarName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(associationBarId);
        softAssert.assertTrue((associationBarId >= 100) && (associationBarId <= 999), "Invalid Association Bar ID");
        softAssert.assertAll();
    }

    @Test(description = "Verify if Attorney ID is valid", dataProvider = "validAttorneyData")
    public void verifyAttorneyIdTest(int attorneyId, String name, String country, String city, int lawFirmId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(attorneyId);
        softAssert.assertTrue(((attorneyId > 1000) && (attorneyId < 2000)), "Invalid Attorney Id");
        softAssert.assertAll();
    }

    @Test(description = "Verify if Attorney Name is valid", dataProvider = "validAttorneyData")
    public void verifyAttorneyNameTest(int attorneyId, String name, String country, String city, int lawFirmId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(name);
        softAssert.assertTrue(name.matches("^[a-zA-Z&\\s-]+$"), "Invalid Attorney Name");
        softAssert.assertAll();
    }


    @Test(description = "Verify if City and Attorney ID is valid", dataProvider = "validAttorneyData")
    public void verifyAttorneyCityTest(int attorneyId, String name, String country, String city, int lawFirmId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(name);
        softAssert.assertTrue(((attorneyId > 1000) && (attorneyId < 2000)), "Invalid Attorney Id");
        softAssert.assertNotNull(city);
        softAssert.assertTrue(city.matches("^[a-zA-Z&\\s-]+$"), "Invalid City Name");
        softAssert.assertAll();
    }


}

package com.sovd.lawoffice;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssociationBarTest {

    @BeforeSuite
    public void setup() {


    }

    @DataProvider(name = "validAssociationBarData")
    public Object[][] validData() {
        return new Object[][]{
                {100, "Akron Bar"}, {102, "Cleveland Bar"}
        };
    }

    @Test(description = "Verify Association Bar with valid Values", dataProvider = "validAssociationBarData")
    public void verifyAssociationBarWithValidTest(int associationBarId, String associationBarName) {
        boolean id = true;
        boolean name = true;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(associationBarId);
        softAssert.assertNotNull(associationBarName);
        softAssert.assertTrue(associationBarName.matches("^[a-zA-Z\\s-]+$"), "Invalid Association Bar Name");
        softAssert.assertTrue((associationBarId >= 100) && (associationBarId <= 999), "Invalid Association Bar ID");
        softAssert.assertAll();
    }

    @Test(description = "Verify Association Bar with Invalid Values", dataProvider = "validAssociationBarData")
    public void verifyAssociationBarWithInvalidTest(int associationBarId, String associationBarName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((associationBarId != 0), "Neg Testcase Invalid Association Bar ID");
        softAssert.assertTrue(associationBarName.matches("^[a-zA-Z\\s-]+$"), "Neg-TestCase Invalid Association Bar Name");
        softAssert.assertAll();
    }

    @Test(description = "Verify if Association Bar ID with valid values", dataProvider = "validAssociationBarData")
    public void verifyAssociationBarIdValidTest(int associationBarId, String associationBarName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(associationBarId);
        softAssert.assertTrue(associationBarId != 0, "Invalid Association Bar ID");
        softAssert.assertAll();
    }
}

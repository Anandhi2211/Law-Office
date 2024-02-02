package com.sovd.lawoffice;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AreaOfPracticeTest {
    public void setup() {

    }

    @DataProvider(name = "validAreaOfPracticeData")
    public Object[][] validAreaOfPracticeData() {
        return new Object[][]{
                {2, "Family Law"},
                {3, "Real estate"}
        };
    }

    @Test(description = "Verify if area of practice if valid", dataProvider = "validAreaOfPracticeData")
    public void verifyAreaOfPracticeIdValidTest(int areaOfPracticeId, String areaOfPracticeName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(areaOfPracticeId);
        softAssert.assertTrue(areaOfPracticeId >= 1 && areaOfPracticeId <= 10, "Invalid Area Of Practice Id");
        softAssert.assertAll();
    }

    @Test(description = "Verify if area of practice if valid", dataProvider = "validAreaOfPracticeData")
    public void verifyAreaOfPracticeIdAndAreaOfPracticeNameValidTest(int areaOfPracticeId, String areaOfPracticeName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(areaOfPracticeId);
        softAssert.assertTrue(areaOfPracticeId >= 1 && areaOfPracticeId <= 10, "Invalid Area Of Practice Id");
        softAssert.assertNotNull(areaOfPracticeName);
        softAssert.assertTrue(areaOfPracticeName.matches("^[a-zA-Z\\s-]+$"), "Invalid Area of Practice name");
        softAssert.assertAll();
    }
}

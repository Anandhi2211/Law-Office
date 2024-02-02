package com.sovd.lawoffice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LawFirmAwardTest {

    public void setup() {

    }

    @Test(description = "Verify lawFirmID is valid", dataProvider = "validLawFirmData", dataProviderClass = LawFirmTest.class)
    public void verifyValidLawFirmIDValidTest(int lawFirmId, String lawFirmName, String address, String country, String city) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(lawFirmId);
        softAssert.assertTrue(((lawFirmId >= 100) && (lawFirmId <= 200)), "Invalid LawFirm ID");
        softAssert.assertAll();
    }

    @Test(description = "Verify Award ID is valid ", dataProvider = "validAwardData", dataProviderClass = AwardTest.class)
    public void verifyValidAwardIdValidTest(int awardId, String awardName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(awardId);
        softAssert.assertTrue((awardId >= 1) && (awardId <= 10), "Invalid Award Id");
        softAssert.assertAll();
    }
}

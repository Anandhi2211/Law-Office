package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CasesTest {

    @DataProvider(name = "validDataCases")
    public Object[][] validData() {
        return new Object[][]{
                {5000, "Hired a buidler to renovate Kitchen which he totally ruined it.", 200, 1001, 1, 11},
                {5001, "applied load to a bank and it bankrupted", 201, 1002, 2, 22}
        };
    }

    @Test(description = "Verify cases Details are valid", dataProvider = "validDataCases")
    public void verifyCaseDetailsAreValidTest(int caseId, String caseDesc, int clientId, int attorneyId, int caseCategoryId, int courtId) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(caseId);
        softAssert.assertNotNull(caseDesc);
        softAssert.assertNotNull(clientId);
        softAssert.assertNotNull(attorneyId);
        softAssert.assertNotNull(caseCategoryId);
        softAssert.assertNotNull(courtId);
        softAssert.assertAll();
    }
}

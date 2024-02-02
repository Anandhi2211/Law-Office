package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class JudgeTest {

    @DataProvider(name = "validJudgeData")
    public Object[][] validData() {
        return new Object[][]{
                {1111, "Ashok"},
                {2222, "Arun"}
        };
    }

    @Test(description = "Verify valid Judge Id and Judge Name", dataProvider = "validJudgeData")
    public void verifyJudgeDetailsValidTest(int judgeId, String judgeName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(judgeId);
        softAssert.assertNotNull(judgeName);
        softAssert.assertTrue(judgeId >= 1000 && judgeId <= 9999, "Invalid Judge ID");
    }
}

package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CourtTest {
    public void setup() {

    }

    @DataProvider(name = "validCourtData")
    public Object[][] validData() {
        return new Object[][]{
                {11, "USA", "cincinnati", 2222},
                {22, "USA", "charlotte", 2222}
        };
    }

    @Test(description = "Verify Court Details valid", dataProvider = "validCourtData")
    public void verifyCourtDetailsValidTest(int court_id, String country, String city, int judge_id) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(court_id);
        softAssert.assertNotNull(country);
        softAssert.assertNotNull(city);
        softAssert.assertNotNull(judge_id);
        softAssert.assertTrue(court_id > 10 && court_id < 99, "Invalid Court Id");
        softAssert.assertTrue(country.matches("^[a-zA-Z\\s-]+$"), "Invalid Country Name");
        softAssert.assertTrue(city.matches("^[a-zA-Z\\s-]+$"), "Invalid City Name");
    }

    @Test(description = "Verify Judge Id is valid", dataProvider = "validJudgeData", dataProviderClass = JudgeTest.class)
    public void verifyJudgeIdValidTest(int judgeId, String name) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(judgeId);
        softAssert.assertTrue(judgeId >= 1000 && judgeId <= 9999, "Invalid Judge ID");
    }
}

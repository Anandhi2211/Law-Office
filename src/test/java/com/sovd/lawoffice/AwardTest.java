package com.sovd.lawoffice;

import org.testng.annotations.DataProvider;

public class AwardTest {

    @DataProvider(name = "validAwardData")
    public Object[][] validData() {
        return new Object[][]{
                {1, "Alexander Award"},
                {2, "Gambrell Awards"}
        };

    }
}

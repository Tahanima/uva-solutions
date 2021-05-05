package io.github.tahanima.problemsetvolumes.volume15;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 05/05/2021
 */
public class _1585Test {
    @DataProvider(name = "sampleData")
    public Object[][] sampleData() {
        return new Object[][] {
                {"OOXXOXXOOO", 10},
                {"OOXXOOXXOO", 9},
                {"OXOXOXOXOXOXOX", 7},
                {"OOOOOOOOOO", 55},
                {"OOOOXOOOOXOOOOX", 30}
        };
    }

    @Test(dataProvider = "sampleData")
    public void testSampleDataGivenInTheProblem(String testResult, int correctScore) {
        Assert.assertEquals(_1585.getScore(testResult), correctScore);
    }
}

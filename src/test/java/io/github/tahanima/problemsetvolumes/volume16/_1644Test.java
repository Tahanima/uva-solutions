package io.github.tahanima.problemsetvolumes.volume16;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 05/14/2021
 */
public class _1644Test {
    @DataProvider(name = "sampleData")
    public Object[][] sampleData() {
        return new Object[][] {
                {10, 4},
                {11, 0},
                {27, 6},
                {2, 0},
                {492170, 114}
        };
    }

    @Test(dataProvider = "sampleData")
    public void testSampleDataGivenInTheProblem(int num, int correctAnswer) {
        _1644.generatePrimeNumbers();
        Assert.assertEquals(_1644.solve(num), correctAnswer);
    }
}

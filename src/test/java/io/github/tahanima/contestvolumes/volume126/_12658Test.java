package io.github.tahanima.contestvolumes.volume126;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 05/06/2021
 */
public class _12658Test {
    @DataProvider(name = "sampleData")
    public Object[][] sampleData() {
        return new Object[][] {
                {".*..*..*..*..*.", 1},
                {"***..*****..***", 2},
                {"***..****..****", 3}
        };
    }

    @Test(dataProvider = "sampleData")
    public void testSampleDataGivenInTheProblem(String digit, int correctAnswer) {
        char[][] temp = {
                digit.substring(0, 3).toCharArray(),
                digit.substring(3, 6).toCharArray(),
                digit.substring(6, 9).toCharArray(),
                digit.substring(9, 12).toCharArray(),
                digit.substring(12, 15).toCharArray()
        };

        if (correctAnswer == 1)
            Assert.assertTrue(_12658.isOne(temp));
        else if (correctAnswer == 2)
            Assert.assertFalse(_12658.isOne(temp) || _12658.isThree(temp));
        else
            Assert.assertTrue(_12658.isThree(temp));
    }
}

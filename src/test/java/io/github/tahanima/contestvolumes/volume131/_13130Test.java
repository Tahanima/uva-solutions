package io.github.tahanima.contestvolumes.volume131;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 04/25/2021
 */
public class _13130Test {
    @DataProvider(name = "sampleData")
    public Object[][] sampleData() {
        return new Object[][] {
                {"1 2 3 4 5", "Y"},
                {"2 3 4 5 6", "Y"},
                {"1 4 4 4 5", "N"},
                {"1 3 4 5 6", "N"},
                {"1 2 2 3 6", "N"}
        };
    }

    @Test(dataProvider = "sampleData")
    public void testSampleDataGivenInTheProblem(String dice, String correctAnswer) {
        String[] diceStr = dice.split(" ");
        int[][] diceInt = new int[1][5];

        for (int i = 0; i < 5; i++)
            diceInt[0][i] = Integer.parseInt(diceStr[i]);

        Assert.assertEquals(_13130.solve(diceInt).replace("\n", ""), correctAnswer);
    }
}

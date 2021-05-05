package io.github.tahanima.problemsetvolumes.volume15;

import java.util.Scanner;

/**
 * @author tahanima
 * @since 05/05/2021
 * @see <a href="https://onlinejudge.org/external/15/1585.pdf">Problem Statement</a>
 */
public class _1585 {
    static int getScore(String testResult) {
        int score = 0, countOfCorrect = 0;

        for (char ch : testResult.toCharArray()) {
            if (ch == 'O')
                score += 1 + (countOfCorrect++);
            else
                countOfCorrect = 0;
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int caseNo = 1; caseNo <= cases; caseNo++) {
            String testResult = input.next();
            System.out.println(getScore(testResult));
        }
    }
}

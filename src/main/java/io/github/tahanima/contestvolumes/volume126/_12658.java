package io.github.tahanima.contestvolumes.volume126;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tahanima
 * @since 05/06/2021
 * @see <a href="https://onlinejudge.org/external/126/12658.pdf">Problem Statement</a>
 */
public class _12658 {
    public static boolean isOne(char[][] digit) {
        for (char[] perString : digit) {
            if (!Arrays.equals(perString, new char[]{'.', '*', '.'}))
                return false;
        }

        return true;
    }

    public static boolean isThree(char[][] digit) {
        boolean odd = true;

        for (char[] perString : digit) {
            if (odd) {
                if (!Arrays.equals(perString, new char[]{'*', '*', '*'}))
                    return false;
            } else {
                if (!Arrays.equals(perString, new char[]{'.', '.', '*'}))
                    return false;
            }

            odd = !odd;
        }

        return true;
    }

    public static char[][] extractDigit(char[][] digits, int start, int end) {
        char[][] digit = new char[5][3];

        for (int row = 0; row < 5; row++) {
            if (end + 1 - start >= 0)
                System.arraycopy(digits[row], start, digit[row], 0, end + 1 - start);
        }

        return digit;
    }

    public static String solve(int n, char[][] digits) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n - 1; i += 4) {
            char[][] currentDigit = extractDigit(digits, i, i + 2);
            answer.append(isOne(currentDigit) ? 1 : ((isThree(currentDigit)) ? 3 : 2));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int noOfDigits = input.nextInt();
        int noOfCharsPerRow = noOfDigits * 4;
        char[][] digits = new char[5][noOfCharsPerRow];

        for (int i = 0; i < 5; i++)
            digits[i] = input.next().toCharArray();

        System.out.println(solve(noOfCharsPerRow, digits));
    }
}

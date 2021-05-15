package io.github.tahanima.problemsetvolumes.volume16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author tahanima
 * @since 05/14/2021
 * @see <a href="https://onlinejudge.org/external/16/1644.pdf">Problem Statement</a>
 */
public class _1644 {
    static final int MAX = 2000000;
    static ArrayList<Integer> primeNumbers;

    public static void generatePrimeNumbers() {
        primeNumbers = new ArrayList<>();
        int[] temp = new int[MAX];

        for (int i = 3; i * i <= MAX; i += 2) {
            if (temp[i] == 0) {
                for(int j = i * i; j < MAX; j += (i + i))
                    temp[j] = 1;
            }
        }

        primeNumbers.add(2);
        for (int i = 3; i < MAX; i += 2) {
            if (temp[i] == 0)
                primeNumbers.add(i);
        }
    }

    public static int solve(int num) {
        if (Collections.binarySearch(primeNumbers, num) >= 0) {
            return 0;
        } else {
            int end = (Collections.binarySearch(primeNumbers, num) + 1) * -1;
            int begin = (end == 0) ? end : end - 1;

            return primeNumbers.get(end) - primeNumbers.get(begin);
        }
    }

    public static void main(String[] args) {
        generatePrimeNumbers();
        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int num = input.nextInt();

            if (num == 0)
                break;

            System.out.println(solve(num));
        }
    }
}

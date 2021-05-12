package io.github.tahanima.contestvolumes.volume124;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author tahanima
 * @since 05/12/2021
 * @see <a href="https://onlinejudge.org/external/124/12459.pdf">Problem Statement</a>
 */
public class _12459 {
    static final int MAX = 85;
    static BigInteger[] fibonacci = new BigInteger[MAX];

    public static void calculateSum() {
        fibonacci[0] = BigInteger.ONE;
        fibonacci[1] = BigInteger.ONE;

        for (int i = 2; i < MAX; i++)
            fibonacci[i] = fibonacci[i - 2].add(fibonacci[i - 1]);
    }

    public static void main(String[] args) {
        calculateSum();
        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int noOfGeneration = input.nextInt();

            if (noOfGeneration == 0)
                break;

            System.out.println(fibonacci[noOfGeneration]);
        }
    }
}

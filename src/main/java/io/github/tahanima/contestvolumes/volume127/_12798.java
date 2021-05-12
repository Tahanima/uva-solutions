package io.github.tahanima.contestvolumes.volume127;

import java.util.Scanner;

/**
 * @author tahanima
 * @since 05/13/2021
 * @see <a href="https://onlinejudge.org/external/127/12798.pdf">Problem Statement</a>
 */
public class _12798 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int n = input.nextInt(), m = input.nextInt();
            int count = 0;

            for (int i = 0; i < n; i++) {
                boolean hasScoredInAll = true;

                for (int j = 0; j < m; j++) {
                    int goal = input.nextInt();
                    hasScoredInAll &= (goal > 0);
                }

                if (hasScoredInAll)
                    count++;
            }

            System.out.println(count);
        }
    }
}

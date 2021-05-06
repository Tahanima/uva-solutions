package io.github.tahanima.contestvolumes.volume131;

import java.util.Scanner;

/**
 * @author tahanima
 * @since 04/25/2021
 * @see <a href="https://onlinejudge.org/external/131/13130.pdf">Problem Statement</a>
 */
public class _13130 {
    public static String solve(int[][] dices) {
        StringBuilder answer = new StringBuilder();

        for (int[] eachDice : dices) {
            boolean isEscala = true;

            for (int i = 1; i < 5; i++)
                isEscala &= (eachDice[i] == (eachDice[i - 1] + 1));

            answer.append(isEscala ? "Y\n" : "N\n");
        }

        return answer.toString();
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        int[][] dices = new int[cases][5];

        for (int caseNo = 0; caseNo < cases; caseNo++)
            for (int i = 0; i < 5; i++)
                dices[caseNo][i] = input.nextInt();

        System.out.print(solve(dices));
    }
}

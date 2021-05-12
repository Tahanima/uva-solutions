package io.github.tahanima.contestvolumes.volume108;

import java.util.*;

/**
 * @author tahanima
 * @since 05/12/2021
 * @see <a href="https://onlinejudge.org/external/108/10887.pdf">Problem Statement</a>
 */
public class _10887 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int caseNo = 1; caseNo <= cases; caseNo++) {
            int m = input.nextInt();
            int n = input.nextInt();

            input.nextLine();

            HashSet<String> set = new HashSet<>();
            String[] firstLanguage = new String[m];

            for (int i = 0; i < m; i++)
                firstLanguage[i] = input.nextLine();

            for (int i = 0; i < n; i++) {
                String word = input.nextLine();

                for (String wordFromFirstLang : firstLanguage) {
                    set.add(wordFromFirstLang + word);
                }
            }

            System.out.printf("Case %d: %d\n", caseNo, set.size());
        }
    }
}

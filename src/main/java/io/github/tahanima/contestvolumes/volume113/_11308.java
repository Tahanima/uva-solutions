package io.github.tahanima.contestvolumes.volume113;

import java.util.*;

/**
 * @author tahanima
 * @since 05/12/2021
 * @see <a href="https://onlinejudge.org/external/113/11308.pdf">Problem Statement</a>
 */
public class _11308 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int caseNo = 1; caseNo <= cases; caseNo++) {
            input.nextLine();
            String binderName = input.nextLine();

            int m = input.nextInt();
            int n = input.nextInt();
            int budget = input.nextInt();
            HashMap<String, Integer> ingredientList = new HashMap<>();
            TreeMap<Integer, ArrayList<String>> chosenList = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                String ingredient = input.next();
                int costPerUnit = input.nextInt();

                ingredientList.put(ingredient, costPerUnit);
            }

            for (int i = 0; i < n; i++) {
                input.nextLine();

                String recipeName = input.nextLine();
                int k = input.nextInt(), cost = 0;

                for (int j = 0; j < k; j++) {
                    String ingredient = input.next();
                    int unit = input.nextInt();

                    cost += unit * ingredientList.get(ingredient);
                }

                if (cost <= budget) {
                    if (chosenList.containsKey(cost)) {
                        ArrayList<String> temp = chosenList.get(cost);

                        temp.add(recipeName);
                        chosenList.replace(cost, temp);
                    } else {
                        ArrayList<String> temp = new ArrayList<>();

                        temp.add(recipeName);
                        chosenList.put(cost, temp);
                    }
                }
            }

            System.out.println(binderName.toUpperCase());

            if (chosenList.size() == 0) {
                System.out.println("Too expensive!");
            } else {
                for (Map.Entry<Integer, ArrayList<String>> entry : chosenList.entrySet()) {
                    ArrayList<String> list = entry.getValue();
                    Collections.sort(list);

                    for (String item : list) {
                        System.out.println(item);
                    }
                }
            }

            System.out.println();
        }
    }
}

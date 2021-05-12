package io.github.tahanima.contestvolumes.volume110;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author tahanima
 * @since 05/12/2021
 * @see <a href="https://onlinejudge.org/external/110/11062.pdf">Problem Statement</a>
 */
public class _11062 {
    public static ArrayList<String> getWordList(String line) {
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (Character ch : line.toCharArray()) {
            if (Character.isLetter(ch) || ch == '-') {
                word.append(ch);
            } else {
                if (word.length() > 0)
                    answer.add(word.toString().toLowerCase());

                word = new StringBuilder();
            }
        }

        if (word.length() > 0)
            answer.add(word.toString().toLowerCase());

        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeSet<String> words = new TreeSet<>();
        StringBuilder line = new StringBuilder();
        boolean hasDash = false;

        while (input.hasNextLine()) {
            String current = input.nextLine().trim();

            if (hasDash) {
                if (current.endsWith("-")) {
                    line.append(current, 0, current.length() - 1);
                } else {
                    line.append(current);
                    hasDash = false;
                }
            } else {
                if (current.endsWith("-")) {
                    line.append(current, 0, current.length() - 1);
                    hasDash = true;
                } else {
                    line.append(current);
                }
            }

            if (!hasDash) {
                ArrayList<String> wordList = getWordList(line.toString());
                words.addAll(wordList);
                line = new StringBuilder();
            }
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}

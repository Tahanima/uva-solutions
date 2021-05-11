package io.github.tahanima.problemsetvolumes.volume12;

import java.io.*;
import java.util.*;

/**
 * @author tahanima
 * @since 05/11/2021
 * @see <a href="https://onlinejudge.org/external/12/1203.pdf">Problem Statement</a>
 */
public class _1203 {
    public static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static class Pair implements Comparable<Pair> {
        int idNumber;
        int basePeriod;
        int nextPeriod;

        public Pair(int idNumber, int basePeriod, int nextPeriod) {
            this.idNumber = idNumber;
            this.basePeriod = basePeriod;
            this.nextPeriod = nextPeriod;
        }

        public int compareTo(Pair toCompare) {
            if (nextPeriod == toCompare.nextPeriod)
                return idNumber - toCompare.idNumber;

            return nextPeriod - toCompare.nextPeriod;
        }
    }

    public static String solve(PriorityQueue<Pair> pq, int noOfQueries) {
        StringBuilder answer = new StringBuilder();

        while (noOfQueries-- > 0) {
            Pair current = pq.peek();
            pq.poll();

            answer.append(current.idNumber).append("\n");
            pq.add(new Pair(current.idNumber, current.basePeriod, current.nextPeriod + current.basePeriod));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        FastReader input = new FastReader();
        String operation = input.next();

        while (!operation.equals("#")) {
            int idNumber = input.nextInt();
            int period = input.nextInt();

            pq.add(new Pair(idNumber, period, period));

            operation = input.next();
        }

        int noOfQueries = input.nextInt();
        System.out.print(solve(pq, noOfQueries));
    }
}

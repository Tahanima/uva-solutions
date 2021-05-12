package io.github.tahanima.contestvolumes.volume119;

import java.util.*;

/**
 * @author tahanima
 * @since 05/11/2021
 * @see <a href="https://onlinejudge.org/external/119/11995.pdf">Problem Statement</a>
 */
public class _11995 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int noOfOperations = input.nextInt();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, Collections.reverseOrder());
            boolean isStack = true, isQueue = true, isPriorityQueue = true;

            for (int i = 1; i <= noOfOperations; i++) {
                int operation = input.nextInt();
                int num = input.nextInt();

                if (operation == 1) {
                    if (isStack)
                        stack.add(num);

                    if (isQueue)
                        queue.add(num);

                    if (isPriorityQueue)
                        priorityQueue.add(num);
                } else {
                    if (isStack) {
                        if (stack.isEmpty()) {
                            isStack = false;
                        } else {
                            int value = stack.pop();
                            isStack = (value == num);
                        }
                    }

                    if (isQueue) {
                        if (queue.isEmpty()) {
                            isQueue = false;
                        } else {
                            int value = queue.poll();
                            isQueue = (value == num);
                        }
                    }

                    if (isPriorityQueue) {
                        if (priorityQueue.isEmpty()) {
                            isPriorityQueue = false;
                        } else {
                            int value = priorityQueue.poll();
                            isPriorityQueue = (value == num);
                        }
                    }
                }
            }

            if (isStack || isQueue || isPriorityQueue) {
                if ((isStack && isQueue) || (isStack && isPriorityQueue) || (isQueue && isPriorityQueue)) {
                    System.out.println("not sure");
                } else {
                    System.out.println((isStack ? "stack" : (isQueue ? "queue" : "priority queue")));
                }
            } else {
                System.out.println("impossible");
            }
        }
    }
}

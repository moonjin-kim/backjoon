package day11.card2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = N; i > 0; i--) {
            deque.add(i);
        }
        while(deque.size() > 1) {
            int firstCard = deque.pollLast();
            int card = deque.pollLast();
            deque.addFirst(card);
        }

        System.out.println(deque.pop());
    }
}

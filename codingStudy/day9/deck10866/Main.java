package day9.deck10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String method = st.nextToken();

            switch (method) {
                case "push_back":
                    int num = Integer.parseInt(st.nextToken());
                    deque.add(num);
                    break;
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        int temp = deque.pollLast();
                        sb.append(temp).append("\n");
                    }
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        int temp = deque.pollFirst();
                        sb.append(temp).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getLast()).append("\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getFirst()).append("\n");
                    }
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

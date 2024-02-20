package day8.queue18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String method = st.nextToken();

            if(method.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }
            else if(method.equals("pop")) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    int temp = queue.get(0);
                    queue.remove(queue.get(0));
                    sb.append(temp).append("\n");
                }
            }
            else if(method.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.get(queue.size() - 1)).append("\n");
                }
            }
            else if(method.equals("front")){
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.get(0)).append("\n");
                }
            }
            else if(method.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            else if(method.equals("size")) sb.append(queue.size()).append("\n");
        }

        System.out.println(sb);
    }
}

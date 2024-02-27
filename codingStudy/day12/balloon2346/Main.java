package day12.balloon2346;

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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> queue = new ArrayDeque<>();
        boolean isRight = true;
        for(int i = 1; i <= N; i++) {
            queue.add(new Balloon(i,Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        while(!queue.isEmpty()) {
            Balloon balloon;
            for(int i=0; i<count; i++) {
                if(isRight){
                    queue.add(queue.poll());
                } else {
                    queue.addFirst(queue.pollLast());
                }
            }

            balloon = queue.poll();
            if(balloon.paper > 0) {
                count = Math.abs(balloon.paper)-1;
                isRight = true;
            } else {
                count = Math.abs(balloon.paper);
                isRight = false;
            }
            sb.append(balloon.idx).append(" ");
        }
        System.out.println(sb);
    }

    static class Balloon {
        int idx;
        int paper;

        public Balloon(int idx, int paper) {
            this.idx = idx;
            this.paper = paper;
        }
    }
}

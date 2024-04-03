package middle.day11.hide12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int start;
    static int end;
    static int min = Integer.MAX_VALUE;
    static int[] time = new int[100001];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if (start >= end) {
            System.out.println((start - end) + "\n1");
            return;
        }

        bfs();
        System.out.println(min);
        System.out.println(count);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        time[start] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(min < time[now]) return;

            for(int i=0; i<3; i++) {
                int next;

                if(i == 0) next = now +1;
                else if(i == 1) next = now -1;
                else next = 2*now;

                if (next < 0 || next > 100000) continue;

                if(next == end) {
                    min = time[now];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[now] + 1){
                    q.add(next);
                    time[next] = time[now] + 1;
                }

            }
        }
    }
}

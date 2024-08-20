package cotest.dp.점프_2253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] speeds = {1, 0, -1};
    static boolean[] small;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        small = new boolean[n+1];
        visited = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(br.readLine());
            small[a] = true;
        }
        System.out.println(bfs(n));
    }

    static int bfs(int n) {
        Queue<Jump> queue = new LinkedList<>();
        queue.add(new Jump(1,0,0));
        visited[1][0] = true;

        while(!queue.isEmpty()) {
            Jump jump = queue.poll();

            for(int i=0; i<3; i++) {
                int next = jump.x + jump.speed + speeds[i];
                int nextJump = jump.speed + speeds[i];
                if(nextJump <= 0) continue;

                if(next > n) continue;
                if(small[next]) continue;
                if(visited[next][nextJump]) continue;
                if(next == n) return jump.count+1;
                visited[next][nextJump] = true;
                queue.add(new Jump(next,nextJump,jump.count+1));
            }
        }

        return -1;
    }

    static class Jump {
        int x;
        int speed;
        int count;

        public Jump(int x, int speed, int count) {
            this.x = x;
            this.speed = speed;
            this.count = count;
        }
    }
}

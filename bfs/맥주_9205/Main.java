package cotest.bfs.맥주_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Node[] route;
    static boolean[] visited;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            route = new Node[M+2];
            visited = new boolean[M+2];
            route[0] = new Node(startX, startY);
            for(int j=1; j<=M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                route[j] = new Node(x,y);
            }
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            route[M+1] = new Node(endX,endY);

            if(bfs()) {
                sb.append("happy").append('\n');
            } else {
                sb.append("sad").append('\n');
            }
        }
        System.out.println(sb);
    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        Node end = route[M+1];
        while(!q.isEmpty()) {
            int curIdx = q.poll();
            Node cur = route[curIdx];
            visited[curIdx] = true;

            if(cur.x == end.x && cur.y == end.y) {
                return true;
            }

            for(int i=1; i<=M+1; i++) {
                int dx = Math.abs(cur.x - route[i].x);
                int dy = Math.abs(cur.y - route[i].y);
                if(dx + dy <= 1000 && !visited[i]) {
                    q.add(i);
                }
            }
        }

        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

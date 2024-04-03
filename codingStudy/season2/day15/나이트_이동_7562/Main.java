package middle.day15.나이트_이동_7562;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] visited;
    static int[] dicX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dicY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            m = Integer.parseInt(br.readLine());
            visited = new int[m][m];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startX,startY);
            System.out.println(visited[endX][endY]-1);
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startX,startY));
        visited[startX][startY] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<8; i++) {
                int nextX = curX + dicX[i];
                int nextY = curY + dicY[i];
                if(isMove(nextX,nextY) && visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = visited[curX][curY]+1;
                    q.add(new Node(nextX,nextY));
                }
            }
        }
    }

    public static boolean isMove(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < m;
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

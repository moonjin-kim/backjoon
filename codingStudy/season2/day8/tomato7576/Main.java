package middle.day8.tomato7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] field;
    static int[][] visited;
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int max = 0;

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        field = new int[m][n];
        visited = new int[m][n];

        ArrayList<Node> start = new ArrayList<>();

        for(int i=0; i<m; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                int point = Integer.parseInt(str.nextToken());
                field[i][j] = point;
                visited[i][j] = point;
                if(point == 1) {
                    start.add(new Node(j,i));
                }
            }
        }

        bfs(start);

        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int point = visited[i][j];
                if(point == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }

                max=Math.max(max,point);
            }
        }

        System.out.println(max-1);
    }

    public static void bfs( ArrayList<Node> start) {
        Queue<Node> q = new ArrayDeque<>();

        for(Node node : start) {
            q.add(node);
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            for(int i=0; i<4;i++) {
                int nextX = curX + DIRECTION_X[i];
                int nextY = curY + DIRECTION_Y[i];

                if(
                        nextX >= 0 &&
                        nextX < n &&
                        nextY >= 0 &&
                        nextY < m &&
                        visited[nextY][nextX] == 0 &&
                        field[nextY][nextX] == 0) {
                    q.add(new Node(nextX,nextY));
                    visited[nextY][nextX] = visited[curY][curX] + 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

package middle.day12.토마토_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][][] field;
    static int[][][] visited;
    static int[] DIRECTION_X = {0,0,1,-1,0,0};
    static int[] DIRECTION_Y = {1,-1,0,0,0,0};
    static int[] DIRECTION_Z = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int max = 0;

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        field = new int[k][m][n];
        visited = new int[k][m][n];

        ArrayList<Node> start = new ArrayList<>();

        for(int u=0; u<k; u++) {
            for(int i=0; i<m; i++) {
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++) {
                    int point = Integer.parseInt(str.nextToken());
                    field[u][i][j] = point;
                    visited[u][i][j] = point;
                    if(point == 1) {
                        start.add(new Node(j,i,u));
                    }
                }
            }
        }


        bfs(start);
        for(int u=0; u<k; u++) {
            for(int i=0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    int point = visited[u][i][j];
                    if(point == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }

                    max=Math.max(max,point);
                }
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
            int curZ = cur.getZ();
            for(int i=0; i<6;i++) {
                int nextX = curX + DIRECTION_X[i];
                int nextY = curY + DIRECTION_Y[i];
                int nextZ = curZ + DIRECTION_Z[i];

                if(
                        nextX >= 0 &&
                        nextX < n &&
                        nextY >= 0 &&
                        nextY < m &&
                        nextZ >=0 &&
                        nextZ < k &&
                        visited[nextZ][nextY][nextX] == 0 &&
                        field[nextZ][nextY][nextX] == 0) {
                    q.add(new Node(nextX,nextY,nextZ));
                    visited[nextZ][nextY][nextX] = visited[curZ][curY][curX] + 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
}

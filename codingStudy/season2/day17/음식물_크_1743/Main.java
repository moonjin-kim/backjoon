package middle.day17.음식물_크_1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[][] field;
    static boolean[][] visited;
    static int[] dicX = {1,0,-1,0};
    static int[] dicY = {0,1,0,-1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        field = new boolean[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<z;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            field[a-1][b-1] = true;
        }


        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(field[i][j] && !visited[i][j])
                    bfs(new Node(j,i));
            }
        }

        System.out.println(max);
    }

    public static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.y][start.x] = true;

        int count = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            count++;

            for(int i =0; i<4; i++) {
                int nx = cur.x + dicX[i];
                int ny = cur.y + dicY[i];

                System.out.println(nx + " " + ny );

                if(isMove(nx,ny) && field[ny][nx] && !visited[ny][nx]) {
                    q.add(new Node(nx,ny));
                    visited[ny][nx] = true;
                }

            }
        }
        System.out.println();
        max = Math.max(max, count);
    }

    public static boolean isMove(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
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

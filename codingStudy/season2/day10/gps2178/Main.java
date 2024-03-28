package middle.day10.gps2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};
    static int n;
    static int m;
    static int[][] field;

    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        field = new int[n][m];
        visited = new int[n][m];
        for(int i=0; i<n;i++) {
            String data = br.readLine();
            for(int j=0; j<m; j++) {
                field[i][j] = data.charAt(j) - '0';
            }
        }

        bfs(new Node(0,0));

    }

    static void bfs(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visited[node.y][node.x] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            for(int i=0; i<4; i++) {
                int nx = cx + DIRECTION_X[i];
                int ny = cy + DIRECTION_Y[i];
                if(
                        nx >= 0 &&
                                nx < m &&
                                ny >= 0 &&
                                ny < n &&
                                visited[ny][nx] == 0 &&
                                field[ny][nx] == 1) {
                    q.add(new Node(nx,ny));
                    visited[ny][nx] = visited[cy][cx] + 1;
                }
            }
        }

        System.out.println(visited[n-1][m-1]);

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

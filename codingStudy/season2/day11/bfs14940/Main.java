package middle.day11.bfs14940;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};
    static int n,m;
    static int[][] field;
    static int count = 0;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        field = new int[n][m];
        visited = new int[n][m];

        Node start = null;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    start = new Node(j,i);
                }
                field[i][j] = a;
            }
        }

        bfs(start);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] == 0 && field[i][j] == 1) {
                    bw.write("-1 ");
                } else {
                    bw.write(visited[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);

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
                        field[ny][nx] == 1 &&
                        visited[ny][nx] == 0
                ) {
                    q.add(new Node(nx,ny));
                    visited[ny][nx] = visited[cy][cx] + 1;
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
    }
}

package middle.day14.벽_부소고_이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static int[][] filed;
    static int[][][] visited;
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        filed = new int[n][m];
        visited = new int[n][m][2];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                filed[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0,0));
    }

    static int bfs(int x, int y, int count) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,count));
        visited[y][x][count]=1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cc = cur.count;

            if(cx == m-1 && cy == n-1)
                return visited[cy][cx][cc];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!isMoved(nx,ny)) continue;
                if(filed[ny][nx] == 1 && cc == 0) {
                    visited[ny][nx][1] = visited[cy][cx][0] + 1;
                    q.add(new Node(nx,ny,1));
                }

                if(filed[ny][nx] == 0 && visited[ny][nx][cc] == 0) {
                    visited[ny][nx][cc] = visited[cy][cx][cc] + 1;
                    q.add(new Node(nx,ny,cc));
                }
            }
        }

        return -1;
    }

    static boolean isMoved(int x, int y) {
        return 0<=x && x<m && 0<=y && y<n;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

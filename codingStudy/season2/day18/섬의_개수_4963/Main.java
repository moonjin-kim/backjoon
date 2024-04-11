package middle.day18.섬의_개수_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] filed;
    static boolean[][] visited;
    static int[] dX = {-1,0,1,1,1,0,-1,-1};
    static int[] dY = {-1,-1,-1,0,1,1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            filed = new int[m][n];
            visited = new boolean[m][n];

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<n; j++) {
                    filed[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int count = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j] && filed[i][j] == 1) {
                        bfs(new Node(j,i));
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visited[node.y][node.x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<8; i++) {
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];

                if(isMove(nX,nY) && !visited[nY][nX] && filed[nY][nX] == 1) {
                    visited[nY][nX] = true;
                    q.add(new Node(nX,nY));
                }
            }
        }
    }

    static boolean isMove(int x, int y) {
        return x >=0 && x < n && y >= 0 && y < m;
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

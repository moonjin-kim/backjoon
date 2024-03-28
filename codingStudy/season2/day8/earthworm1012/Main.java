package middle.day8.earthworm1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] field;
    static boolean[][] visited;
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<num;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            field = new boolean[m][n];
            visited = new boolean[m][n];

            for(int j=0; j<x; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                field[a][b] = true;
            }

            for(int j=0; j<m; j++) {
                for(int k=0; k<n; k++) {
                    if(!visited[j][k] && field[j][k]) {
                        bfs(m,n,new Node(j,k));
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int m, int n, Node start) {
        Queue<Node> que = new ArrayDeque<>();

        que.add(start);
        visited[start.getX()][start.getY()] = true;

        while(!que.isEmpty()) {
            Node node = que.poll();
            int curX = node.getX();
            int curY = node.getY();

            for(int i=0; i<4; i++) {
                int nextX = curX + DIRECTION_X[i];
                int nextY = curY + DIRECTION_Y[i];

                if(
                        nextX >= 0 &&
                        nextX < m &&
                        nextY >= 0 &&
                        nextY < n &&
                        !visited[nextX][nextY] &&
                        field[nextX][nextY]) {
                    que.add(new Node(nextX,nextY));
                    visited[nextX][nextY] = true;
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

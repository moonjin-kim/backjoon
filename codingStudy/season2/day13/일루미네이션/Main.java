package middle.day13.일루미네이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[][] visited;
    static int[][] field;
    static int[] EVEN_DIRECTION_X = {1,1,1,0,-1,0};
    static int[] EVEN_DIRECTION_Y = {-1,0,1,1,0,-1};
    static int[] ODD_DIRECTION_X = {0,1,0,-1,-1,-1};
    static int[] ODD_DIRECTION_Y = {-1,0,1,1,0,-1};
    static int[] DIC_X={1,0,-1,0};
    static int[] DIC_Y={0,1,0,-1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        field = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                field[i][j] = a;
            }
        }

        int x =0;
        int y = 0;
        for(int i = 0; i < 4; i++) {
            int target = 0;
            if(i % 2 == 0) target = n;
            else target = m;

            for(int j=0; j<target-1; j++) {
                x += DIC_X[i];
                y += DIC_Y[i];
                if(!visited[y][x] && field[y][x] == 0) {
                    visited[y][x] = true;
                    bfs(new Node(x,y));
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            int target = 0;
            if(i % 2 == 0) target = n;
            else target = m;

            for(int j=0; j<target-1; j++) {
                x += DIC_X[i];
                y += DIC_Y[i];
                if(field[y][x] == 1) {
                    calCorner(x, y);
                }
            }
        }



        System.out.println(count);

    }

    static void calCorner(int x, int y) {
        if(y%2 == 0) {
            for(int i=0; i<6; i++) {
                int nextX = x + EVEN_DIRECTION_X[i];
                int nextY = y + EVEN_DIRECTION_Y[i];
                if(!isMove(nextX,nextY)) count ++;
            }
        } else {
            for(int i=0; i<6; i++) {
                int nextX = x + ODD_DIRECTION_X[i];
                int nextY = y + ODD_DIRECTION_Y[i];
                if(!isMove(nextX,nextY)) count ++;
            }
        }
    }

    static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);


        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            if(curY%2 == 0) {
                for(int i=0; i<6; i++) {
                    int nextX = curX + EVEN_DIRECTION_X[i];
                    int nextY = curY + EVEN_DIRECTION_Y[i];
                    if(isMove(nextX,nextY) &&
                            !visited[nextY][nextX] &&
                            field[nextY][nextX] == 0
                    ) {
                        q.add(new Node(nextX,nextY));
                        visited[nextY][nextX] = true;
                    } else if(isMove(nextX,nextY) &&
                            field[nextY][nextX] == 1) {
                        count++;
                    }
                }
            } else {
                for(int i=0; i<6; i++) {
                    int nextX = curX + ODD_DIRECTION_X[i];
                    int nextY = curY + ODD_DIRECTION_Y[i];
                    if(isMove(nextX,nextY) &&
                            !visited[nextY][nextX] &&
                            field[nextY][nextX] == 0
                    ) {
                        q.add(new Node(nextX,nextY));
                        visited[nextY][nextX] = true;
                    } else if(isMove(nextX,nextY) &&
                            field[nextY][nextX] == 1) {
                        count++;
                    }
                }
            }
        }
    }

    public static boolean isMove(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
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

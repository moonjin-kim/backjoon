package middle.day14.인구_이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    static ArrayList<Node> unionXY = new ArrayList<>();
    static boolean visit[][];
    static int map[][];
    static int n,l,r,cnt;
    static boolean isMove = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(cnt);
    }

    static void move() {
        while(true) {
            isMove = false;
            visit = new boolean[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visit[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            if(!isMove) break;
            else cnt++;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visit[x][y] = true;
        unionXY.add(new Node(x,y));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(isMoved(nextX,nextY) &&
                    !visit[nextX][nextY] &&
                    l <= Math.abs(map[curX][curY] - map[nextX][nextY]) &&
                    Math.abs(map[curX][curY] - map[nextX][nextY]) <= r) {
                    isMove = true;
                    visit[nextX][nextY] = true;
                    unionXY.add(new Node(nextX,nextY));
                    q.add(new Node(nextX,nextY));
                }
            }
        }

        int sum = 0;
        for(int i=0; i<unionXY.size(); i++) {
            Node node = unionXY.get(i);
            sum += map[node.x][node.y];
        }

        for(int i=0; i<unionXY.size(); i++) {
            Node node = unionXY.get(i);
            map[node.x][node.y] = sum / unionXY.size();
        }
        unionXY.removeAll(unionXY);
    }

    static boolean isMoved(int x, int y) {
        return 0<=x && x<n && 0<=y && y<n;
    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}



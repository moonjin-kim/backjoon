package middle.day13.꽃길_14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] field;
    static int[] DIRECTION_X = {0,0,0,1,-1};
    static int[] DIRECTION_Y = {0,1,-1,0,0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        field = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                field[i][j] = a;
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    static void dfs(int count, int value) {
        if(count == 3) {
            min = Math.min(min,value);
            return;
        }

        for(int i=1; i<n-1;i++) {
            for(int j=1; j<n-1; j++) {
                if(!isVisited(i,j)) {
                    int money = rental(i,j);
                    dfs(count+1, value+money);
                    returnField(i,j);
                }
            }
        }
    }

    static boolean isVisited(int x, int y) {
        for(int i=0; i<5; i++) {
            if(visited[x+DIRECTION_X[i]][y+DIRECTION_Y[i]]) {
                return true;
            }
        }
        return false;
    }

    static int rental(int x, int y) {
        int value = 0;
        for(int i=0; i<5; i++) {
            visited[x+DIRECTION_X[i]][y+DIRECTION_Y[i]] = true;
            value += field[x+DIRECTION_X[i]][y+DIRECTION_Y[i]];
        }
        return value;
    }

    static void returnField(int x, int y) {
        for(int i=0; i<5; i++) {
            visited[x+DIRECTION_X[i]][y+DIRECTION_Y[i]] = false;
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

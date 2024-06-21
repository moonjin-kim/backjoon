package cotest.분할정복.색종이만들기_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] area;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        area = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void dfs(int x, int y, int size) {
        int startNum = area[x][y];
        if(colorCheck(x,y,size)) {
            if(startNum == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        dfs(x,y,newSize);
        dfs(x+newSize,y,newSize);
        dfs(x,y+newSize,newSize);
        dfs(x+newSize,y+newSize,newSize);

    }

    static public boolean colorCheck(int x, int y, int size) {
        int startNum = area[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(startNum != area[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

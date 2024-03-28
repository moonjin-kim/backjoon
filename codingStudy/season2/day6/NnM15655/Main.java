package middle.day6.NnM15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs("" + num[i], i+1,1);
            visited[i] = false;
        }
    }

    public static void dfs(String str,int idx ,int count) {
        if(count == k) {
            System.out.println(str);
            return;
        }

        if(idx == n) {
            return;
        }

        for(int i=idx; i<n; i++) {
            visited[i] = true;
            dfs(str + " " + num[i], i+1, count+1);
            visited[i] = false;
        }
    }
}

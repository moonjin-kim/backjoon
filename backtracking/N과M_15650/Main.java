package cotest.backtracking.N과M_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer> list;
    static Set<ArrayList<Integer>> set;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList<>();

        dfs(0,0,sb);
        System.out.println(sb.toString());
    }

    static void dfs(int cur,int len, StringBuilder sb) {
        if(len == M) {
            for(int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        for(int i = cur; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i+1);
                dfs(i+1,len+1, sb);
                visited[i] = false;
                list.remove(len);
            }
        }

    }
}

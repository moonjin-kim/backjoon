package middle.day12.abcde_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        list = new ArrayList[n];

        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<n;i++) {
            dfs(i,1);
        }

        System.out.println(0);
    }

    static void dfs(int idx,int count) {
        if(count == 5) {
            System.out.println(1);
            System.exit(0);
        }

        visited[idx] = true;
        for(int i: list[idx]) {
            if(!visited[i]) {
                dfs(i,count+1);
            }
        }
        visited[idx] = false;
    }
}

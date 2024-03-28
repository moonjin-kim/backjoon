package middle.day9.tree11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        isVisit = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);

        for(int i=2; i< N+1; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int index) {
        isVisit[index] = true;
        for(int i : list[index]) {
            if(!isVisit[i]) {
                parent[i] = index;
                dfs(i);
            }
        }
    }

    static void bfs(int index) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(index);

        while(!q.isEmpty()) {
            int start = q.poll();
            isVisit[start] = true;
            for(int i : list[start]) {
                if(!isVisit[i]) {
                    parent[i] = start;
                    q.add(i);
                }
            }
        }

    }
}

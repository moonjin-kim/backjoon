package middle.day9.graph14675;

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
    static ArrayList<Integer> copyList[];

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

        StringBuilder sb = new StringBuilder();
        int q=Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if(op == 2) {
                sb.append("yes\n");
            } else {
                int idx = Integer.parseInt(st.nextToken());
                if(list[idx].size() >= 2) sb.append("yes\n");
                else sb.append("no\n");
            }
        }

        System.out.println(sb);

    }

}

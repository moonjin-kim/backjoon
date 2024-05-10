package cotest.graph.거짓말_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> trustParty = new HashSet<>();
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer>[] partyMembers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new ArrayList[N+1];
        partyMembers = new ArrayList[M];
        visited = new boolean[M];
        for(int i=0;i<N+1;i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++) {
            partyMembers[i] = new ArrayList<Integer>();
        }

        int truthLen = Integer.parseInt(st.nextToken());
        ArrayList<Integer> truth_humans = new ArrayList<>();
        for(int i=0; i<truthLen; i++) {
            truth_humans.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            for(int j=0; j<len; j++) {
                int human = Integer.parseInt(st.nextToken());
                arr[human].add(i);
                partyMembers[i].add(human);
            }
        }


        for(int trust: truth_humans) {
            for(int partyNum : arr[trust]) {
                if(!visited[partyNum]) {
                    dfs(partyNum);
                }
            }
        }

        System.out.println(M - trustParty.size());

    }

    static void dfs(int partyNum) {
        visited[partyNum] = true;
        trustParty.add(partyNum);
        for(int member : partyMembers[partyNum]) {
            for(int num : arr[member]) {
                if(!visited[num]) {
                    dfs(num);
                }
            }
        }
    }
}

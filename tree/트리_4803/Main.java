package cotest.tree.트리_4803;

import java.io.*;
import java.util.*;

public class Main {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 0 0이면 종료
            if (n == 0 && m == 0) break;
            visited = new boolean[n + 1];

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int tree = 0;
            for(int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    tree += checkTree(i);
                }
            }
            bw.write("Case " + testCase + ": ");

            if (tree > 1) {
                bw.write("A forest of " + tree + " trees.");
            } else if (tree == 1) {
                bw.write("There is one tree.");
            } else {
                bw.write("No trees.");
            }
            bw.write("\n");

            testCase++;
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int checkTree(int root) {
        Queue<Integer> que = new LinkedList<>();
        int node = 0;
        int edge = 0;

        que.add(root);
        while(!que.isEmpty()) {
            int cur = que.poll();

            if(visited[cur]) continue;
            visited[cur] = true;
            node++;

            for(int i: graph.get(cur)) {
                edge++;
                if(!visited[i]) que.add(i);
            }
        }

        return (edge / 2) + 1 == node ? 1 : 0;
    }
}

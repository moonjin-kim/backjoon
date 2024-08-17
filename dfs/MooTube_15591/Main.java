package cotest.bfs.MooTube_15591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Mootube>[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        route = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            route[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());

            route[p].add(new Mootube(q, r));
            route[q].add(new Mootube(p, r));
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(v);
            visit[v] = true;

            int ans = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();

                for(Mootube next : route[cur]) {
                    if(next.usado >= k && !visit[next.video]) {
                        q.add(next.video);
                        visit[next.video] = true;
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static class Mootube {
        int video;
        long usado;

        Mootube(int video, long usado) {
            this.video = video;
            this.usado = usado;
        }
    }
}

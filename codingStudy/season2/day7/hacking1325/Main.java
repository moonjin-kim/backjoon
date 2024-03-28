package middle.day7.hacking1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static ArrayList <Integer>[] arr;
    static boolean check[]; // 방문 배열
    static int hacking[]; // 해킹 가능 컴퓨터 체크
    static int max=0;
    static int n, line;
    static int count = 0;
    static ArrayList<Integer> maxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        line = Integer.parseInt(str.nextToken());

        arr = new ArrayList[n+1];
        hacking = new int[n+1];
        for (int i=0; i<n+1; i++) {
            arr[i] = new ArrayList <Integer>();
        }
        for(int i=0; i<line; i++) {
            str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a].add(b);
        }

        for(int i = 0; i<= n; i++) {
            check = new boolean[n+1];
            bfs(i);
        }

        maxs  = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (max < hacking[i]) {
                maxs = new ArrayList<>();
                maxs.add(i);
                max = hacking[i];
            } else if (max == hacking[i]) {
                maxs.add(i);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i: maxs) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }


    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()) {
            int a = q.poll();

            for(int target : arr[a]) {
                if(!check[target]) {
                    q.add(target);
                    check[target] = true;
                    hacking[target]++;
                }
            }
        }
    }
}

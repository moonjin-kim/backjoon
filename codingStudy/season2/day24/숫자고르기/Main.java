package middle.day24.숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> list;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        for(int i=1; i<=n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        list = new PriorityQueue<>();
        visited = new boolean[n + 1];

        for(int i=1; i <=n; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        int size = list.size();
        System.out.println(size);
        for(int i = 0; i <size; i++) {
            System.out.println(list.poll());
        }
    }

    public static void dfs(int start, int target) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start],target);
            visited[num[start]] = false;
        }
        if(num[start] == target ) list.add(target);
    }
}

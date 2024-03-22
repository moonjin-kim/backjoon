package middle.day5.leave14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int max = 0;
    static Consulting[] consultings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        consultings = new Consulting[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            consultings[i] = new Consulting(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for(int i=0; i < n; i++) {
            if(i+consultings[i].getTime() <= n) {
                dfs(consultings[i].getPrice(),i+consultings[i].getTime());
            }
        }

        System.out.println(max);
    }

    public static void dfs(int price, int day) {
        if(day == n) {
            max = Math.max(price,max);
            return;
        }

        for(int i=day; i<n; i++) {
            if(i+consultings[i].getTime() <= n) {
                dfs(price + consultings[i].getPrice(),i+consultings[i].getTime());
            }
        }

        max = Math.max(price,max);
    }

    static class Consulting {
        int time;
        int price;

        public Consulting(int time, int price) {
            this.time = time;
            this.price = price;
        }

        public int getTime() {
            return time;
        }

        public int getPrice() {
            return price;
        }
    }
}

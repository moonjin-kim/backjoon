package middle.day5.cooking2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //dfs 그리드 문제
    static int n;
    static long min=Long.MAX_VALUE;
    static Food[] cooks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cooks = new Food[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            cooks[i] = new Food(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for(int i=0; i<n; i++) {
            long makeSour = cooks[i].getSour();
            long makeSweet = cooks[i].getSweetness();
            long diff = Math.abs(makeSour - makeSweet);
            min = Math.min(min,diff);
            dfs(i+1,new Food(makeSour,makeSweet));
        }

        System.out.println(min);
    }

    public static void dfs(int step, Food cook) {
        if(step == n) return;

        for(int i=step; i<n; i++) {
            long makeSour = cook.getSour() * cooks[i].getSour();
            long makeSweet = cook.getSweetness() + cooks[i].getSweetness();
            long diff = Math.abs(makeSour - makeSweet);
            min = Math.min(min,diff);
            dfs(i+1,new Food(makeSour,makeSweet));
        }
    }

    static class Food {
        long sour;
        long sweetness;

        public Food(long sour, long sweetness) {
            this.sour = sour;
            this.sweetness = sweetness;
        }

        public long getSour() {
            return sour;
        }

        public long getSweetness() {
            return sweetness;
        }
    }
}

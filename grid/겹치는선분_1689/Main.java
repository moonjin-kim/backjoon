package cotest.greed.겹치는_선분_1689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] checked = new int[1000000000];
    static int maxLen = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Spot> spots = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            spots.add(new Spot(a, 1));
            spots.add(new Spot(b, -1));
        }
        Collections.sort(spots);


        int max = 0;
        int count=0;
        for(Spot spot : spots) {
            if(spot.type == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }

        System.out.println(max);
    }

}

class Spot implements Comparable<Spot> {
    int point;
    int type;

    public Spot(final int point, final int type) {
        this.point = point;
        this.type = type;
    }

    @Override
    public int compareTo(final Spot o) {
        if (point == o.point) {
            return Integer.compare(type, o.type);
        }
        return Integer.compare(point, o.point);
    }
}

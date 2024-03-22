package middle.day2.backjack2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxNum;
    static int answer=0;
    static int n;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        maxNum = Integer.parseInt((st.nextToken()));

        card = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < n-2; i++) {
            selectCard(card[i],1,i+1);
        }

        System.out.println(answer);
    }

    public static void selectCard(int num, int count, int idx) {

        if(count == 3) {
            if(num <= maxNum) {
                answer = Math.max(num,answer);
            }
            return;
        }

        if(idx >= n) {
            return;
        }


        selectCard(num+card[idx],count + 1, idx + 1);
        selectCard(num,count,idx+1);
    }
}

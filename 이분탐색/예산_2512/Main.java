package cotest.이분탐색.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] budgets;
    public static void main(String[] args) throws IOException {
        int left=0, right=1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(br.readLine());
        budgets = new int[n];
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budgets[i]);
        }
        while(left<=right){
            int mid = (left + right)/2;
            long budgetSum = 0;
            for(int budget : budgets){
                if(budget<mid){
                    budgetSum += budget;
                } else {
                    budgetSum += mid;
                }
            }
            if(budgetSum <= money){
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}

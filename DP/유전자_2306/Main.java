package cotest.dp.유전자_2306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dna = br.readLine();

        int[][] dp = new int[dna.length()+1][dna.length()+1];

        for (int size = 1; size < dna.length(); size++) {
            for (int start = 0; start+size<dna.length(); start++) {
                int end=start+size;
                if((dna.charAt(start)=='a'&&dna.charAt(end)=='t')|| (dna.charAt(start)=='g'&&dna.charAt(end)=='c')) {
                    dp[start][end]=dp[start+1][end-1]+2;
                }
                for(int mid=start;mid<end;mid++) {
                    dp[start][end]=Math.max(dp[start][end], dp[start][mid]+dp[mid+1][end]);
                }
            }
        }

        int max = 0;
        for(int start = 0; start <= dna.length(); start++) {
            for (int end = 0; end <= dna.length(); end++) {
                max = Math.max(max, dp[start][end]);
            }
        }

        System.out.println(max);
    }
}

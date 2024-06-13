package cotest.dp.LCS_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        word = new int[str1.length()+1][str2.length()+1];
        int max = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    word[i][j] = word[i-1][j-1]+1;
                } else {
                    word[i][j] = Math.max(word[i-1][j], word[i][j-1]);
                }
                max = Math.max(max, word[i][j]);
            }
        }

        System.out.println(max);
    }
}

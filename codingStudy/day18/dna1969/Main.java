package day18.dna1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // dna 수
        int m = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int[][] alphabet = new int[m][26];
        StringBuilder sb = new StringBuilder();
        int hammingDistance = 0;

        String[] dnas = new String[n];
        for (int i = 0; i < n; i++) {
            dnas[i] = br.readLine();

            for (int j = 0; j < m; j++) {
                /* 굳이 A가 int로 65인 것을 생각할 필요없이 'A'를 빼주면 된다. */
                alphabet[j][dnas[i].charAt(j) - 'A'] += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int max = alphabet[i][0];
            char target = 'A';
            for (int j = 0; j < 26; j++) {
                if (alphabet[i][j] > max) {
                    max = alphabet[i][j];
                    target = (char) (j + 'A');
                }
            }
            sb.append(target);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dnas[i].charAt(j) != sb.charAt(j)) hammingDistance++;
            }
        }

        System.out.println(sb.toString());
        System.out.println(hammingDistance);
    }
}

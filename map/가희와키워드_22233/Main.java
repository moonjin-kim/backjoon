package cotest.map.가희와키워드_22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Boolean> memo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            memo.put(br.readLine(), true);
        }

        for (int i = 0; i < m; i++) {
            String[] keywords = br.readLine().split(",");
            for (int j = 0; j < keywords.length; j++) {
                if(memo.get(keywords[j]) != null && memo.get(keywords[j])) {
                    n--;
                    memo.put(keywords[j], false);
                }
            }
            System.out.println(n);
        }
    }
}

package day7.stack9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            String bracket = br.readLine();
            int left = 0;
            Stack<Character> s = new Stack<>();
            int count = 0;
            for(char b : bracket.toCharArray()) {
                if(b == '('){
                    count++;
                    s.add(b);
                }
                else {
                    if(!s.isEmpty()) {
                        count++;
                        s.pop();
                    } else{
                        break;
                    };
                }
            }

            if(count == bracket.length() && s.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }
}

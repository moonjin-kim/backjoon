package day2.CheckGroupWorld1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < len; i++) {
            String word = br.readLine();
            if(checkGroupWord(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkGroupWord(String word) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!set.contains(currentChar)) {
                set.add(currentChar);
            } else {
                char beforeChar = word.charAt(i-1);
                if(beforeChar != currentChar) {
                    return false;
                }
            }
        }

        return true;
    }
}

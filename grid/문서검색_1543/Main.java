package cotest.greed.문서검색_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dic = br.readLine();
        String word = br.readLine();

        int size = dic.length();
        int size2 = word.length();

        dic = dic.replace(word,"");
        System.out.println((size - dic.length()) / size2);
    }
}

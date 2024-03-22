package day3.wordStudy1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character,Integer> charMap = new HashMap<>();
        String word = br.readLine();

        word = word.toUpperCase();

        for(int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            charMap.put(s,charMap.getOrDefault(s,0)+1);
        }

        char maxStr = checkMaxChar(charMap);

        System.out.println(maxStr);
    }

    public static char checkMaxChar(HashMap<Character, Integer> charMap) {
        //value를 기준으로 내림차순 정렬
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(charMap.entrySet());
        entryList.sort(((o1, o2) -> charMap.get(o2.getKey()) - charMap.get(o1.getKey())));
        int maxCount = 0;
        char maxStr = ' ';
        int idx = 0;

        for(Map.Entry<Character, Integer> entry : entryList){
            if(idx == 0) {
                maxCount = entry.getValue();
                maxStr = entry.getKey();
                idx++;
            } else {
                if(maxCount == entry.getValue()) maxStr = '?';
                break;
            }
        }

        return maxStr;
    }
}

package day1.decryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        for(int i = 0; i < len; i++) {
            String cryptogram = br.readLine();
            HashMap<Character, Integer> charMap = countChar(cryptogram);

            //value 기준으로 정렬
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
            System.out.println(maxStr);
        }
    }

    static HashMap<Character, Integer> countChar(String str) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char s : str.toCharArray()) {
            if(s != ' ') {
                charMap.put(s,charMap.getOrDefault(s,0)+1);
            }
        }

        return charMap;
    }


}

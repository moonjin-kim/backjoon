package day1.subString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String subStr = sc.next();

        System.out.println(KMP(str,subStr));
    }

    static String KMP(String str, String subStr) {
        int[] table = makeTable(subStr);
        int lenStr = str.length();
        int lenSubStr = subStr.length();


        int idx = 0;
        for(int i = 0 ; i < lenStr; i++) {
            while(idx > 0 && str.charAt(i) != subStr.charAt(idx)) {
                idx=table[idx-1];
            }

            if(str.charAt(i) == subStr.charAt(idx)) {
                if(idx == lenSubStr -1) {
                    idx = table[idx];
                    return "1";
                } else {
                    idx++;
                }
            }
        }
        return "0";
    }

    static int[] makeTable(String subStr) {
        int n = subStr.length();
        int[] table = new int[n];

        int idx = 0;
        for(int i=1; i<n; i++) {
            while(idx>0 && subStr.charAt(i) != subStr.charAt(idx))  {
                idx = table[idx - 1];
            }

            if(subStr.charAt(i) == subStr.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }


        return table;
    }
}

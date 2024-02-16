package day4.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] arr= new int[200];
    static String max = String.valueOf(Math.pow(2, 63));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int count = 0;
        String x = "0";
        int a = 2;
        int b = 2;

        int numMin1 = 2;
        int numMin2 = 2;

        for(int i=0; i<9; i++){
            arr[i+'1']=i+1;
        }
        for(int i=0; i<26; i++){
            arr['a'+i]=i+10;
        }

        numMin1 = Math.max(checkMin(num1)+1,2);
        numMin2 = Math.max(checkMin(num2)+1,2);

        for(int i = numMin1; i <= 36; i++) {
            String decNum1 = find(i,num1);
            for(int j = numMin2; j <= 36; j++) {
                if(i == j) continue;
                String decNum2 = find(j,num2);
                if(decNum2.equals(decNum1)) {
                    if(decNum1.compareTo(max) >= 1) continue;
                    count++;
                    x = decNum2;
                    a = i;
                    b = j;
                }
            }
        }

        if(count == 0) {
            System.out.println("Impossible");
        } else if(count == 1) {
            String toInteger = x.substring(0, x.length() - 2);
            System.out.println(toInteger + " " + a + " " + b);
        } else {
            System.out.println("Multiple");
        }

    }

    public static String find(int a, String s){
        int temp=0;
        double result=0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            int t = arr[s.charAt(i)];
            result += Math.pow(a, temp) * t;
            temp++;
        }
        return String.valueOf(result);
    }

    public static int checkMin(String num) {
        int maxNum = 0;
        for(int i=0; i < num.length(); i++) {
            char currentChar = num.charAt(i);
            maxNum = Math.max(maxNum,arr[currentChar]);
        }

        return maxNum;
    }
}

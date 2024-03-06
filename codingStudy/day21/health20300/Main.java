package day21.health20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long [] weight = new long[n];
        for(int i=0; i<n; i++){
            weight[i] = sc.nextLong();
        }
        Arrays.sort(weight);
        long maxnum = 0;
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                maxnum = Math.max(maxnum,weight[i]+weight[n-1-i]);
            }
        }else{
            maxnum = weight[n-1];
            for(int i=0; i<(n-1)/2; i++){
                maxnum = Math.max(maxnum, weight[i]+weight[n-2-i]);
            }
        }


        System.out.println(maxnum);
    }

}

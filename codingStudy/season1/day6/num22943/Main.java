package day6.num22943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int LIMIT = 98765;
    static boolean[] isNotPrime;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    static boolean[] visited= new boolean[10];
    static boolean[] primeSum, primeMult;
    static int Max;
    static int answer = 0;
    static int K, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Max = (int) Math.pow(10, K);
        primeSum = new boolean[Max];
        primeMult = new boolean[Max];

        makePrime(LIMIT);
        sumPrime();
        multiplePrime();

        comb(0,0);
        System.out.println(answer);
    }

    public static void comb(int idx, int num) {
        if (idx == K) {
            if(valid(num)) {
                answer++;
                return;
            }
        }
        for (int i=0; i < 10; i++) {
            if (i==0 && idx == 0 || visited[i]) continue;
            visited[i] = true;
            comb(idx+1,num*10 + i);
            visited[i] = false;
        }
    }

    public static boolean valid(int n) {
        if(!primeSum[n]) return false;
        while(n%M == 0) {
            n /= M;
        }
        if(!primeMult[n]) return false;
        return true;
    }

    public static void makePrime(int N) {
        isNotPrime = new boolean[N+1];
        if(N < 2) return;
        isNotPrime[0] = isNotPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(isNotPrime[i]) continue;
            for(int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }

        for(int i = 2; i<= N; i++) {
            if(!isNotPrime[i]) primeNumbers.add(i);
        }
    }

    public static void sumPrime() {
        outer:
        for(int i =0; i < primeNumbers.size() - 1;i++) {
            int a = primeNumbers.get(i);
            for(int j = i +1; j < primeNumbers.size(); j++) {
                int b = primeNumbers.get(j);
                if(a + b >= Max) continue outer;
                primeSum[a+b] = true;
            }
        }
    }

    public static void multiplePrime() {
        outer:
        for(int i =0; i < primeNumbers.size();i++) {
            int a = primeNumbers.get(i);
            for(int j = 0; j < primeNumbers.size(); j++) {
                int b = primeNumbers.get(j);
                long num = (long) a * (long)b;
                if(num >= Max) {
                    continue outer;
                }
                primeMult[a*b] = true;
            }
        }
    }
}

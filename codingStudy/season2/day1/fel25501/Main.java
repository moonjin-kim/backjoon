package middle.day1.fel25501;

import java.io.*;

public class Main {
    static int count = 0;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        count = 0;
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++ ) {
            String word = br.readLine();
            int isPal = isPalindrome(word);
            bw.write(isPal + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

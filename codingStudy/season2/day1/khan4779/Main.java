package middle.day1.khan4779;

import java.io.*;

public class Main {
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = null;

        while((n = br.readLine()) != null) {
            int num = Integer.parseInt(n);
            answer = new StringBuilder();
            khan(num);

            System.out.println(answer);
        }

    }

    public static void khan(int n){
        if(n == 0) {
            answer.append("-");
        } else {
            khan(n - 1);
            for(int i = 0; i < Math.pow(3,n-1); i++) {
                answer.append(" ");
            }
            khan(n - 1);
        }

    }
}

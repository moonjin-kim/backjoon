package day20.polyomino;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String polyomino = br.readLine();
        int n = 0;
        for(int i=0; i<polyomino.length();i++) {
            char text = polyomino.charAt(i);
            if(n == 4) {
                bw.write("AAAA");
                n=0;
            }

            if(text == 'X') {
                n++;
            } else {
                if (n==2) {
                    bw.write("BB");
                } else if(n != 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                bw.write(".");
                n=0;
            }
        }

        if(n == 4) {
            bw.write("AAAA");
        } else if(n == 2) {
            bw.write("BB");
        } else if(n%2 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

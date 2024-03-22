package day13.math2870;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<BigDecimal> set = new ArrayList<>();
        String regex = "([\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        for(int i=0; i< N; i++) {
            String text = br.readLine();

            matcher = pattern.matcher(text);
            while(matcher.find()) {
                set.add(new BigDecimal(matcher.group()));
            }
        }

        ArrayList<BigDecimal> al = new ArrayList<>(set);

        Collections.sort(al);
        for(BigDecimal num : al) {
            bw.write(num+"");
            bw.newLine();
        }
        bw.flush();
    }

}

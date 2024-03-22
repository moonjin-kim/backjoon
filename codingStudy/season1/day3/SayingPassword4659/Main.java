package day3.SayingPassword4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String regex = "^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+";
        Pattern pattern = Pattern.compile(regex);

        while(!(str = br.readLine()).equals("end")) {
            Matcher matcher = pattern.matcher(str);
            String result = matcher.find()?"not acceptable.":"acceptable.";
            System.out.println("<"+str+"> is " +  result);
        }
    }
}

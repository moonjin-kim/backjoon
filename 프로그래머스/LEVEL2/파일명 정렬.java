import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (o1, o2) -> {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if (result == 0) { 
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                }
                
                return result;
            });
        return files;
    }
    
    private Integer convertNum(String str, String head) {
        String number = "";
        for(int i = head.length();i<str.length();i++){
            Character c = str.charAt(i);
            if (Character.isDigit(c) && number.length() < 5) // 숫자인지 그리고 result 길이가 5가 안 넘는지 확인
                number += c;
            else
                break;
        }

        return Integer.valueOf(number);
    }
}


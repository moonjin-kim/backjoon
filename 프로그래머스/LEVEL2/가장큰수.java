 import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        String answer="";
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        //문자열을 붙혀서 비교 ex) 3,30의 순서를 비교할때 330과 303을 비교함
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        //배열이 [0,0,0]이면 000이 아니라 0인 경우 고려
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for(String str:arr){
            stringBuilder.append(str);
        }
        
        return stringBuilder.toString();
    }
}
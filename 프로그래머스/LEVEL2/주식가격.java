import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> answer = new ArrayList<>();
        int pricesSize = prices.length;
        
        for(int i=0; i < prices.length; i++){
            answer.add(0);
            while(!stack.isEmpty()){
                int position = stack.peek();
                if(prices[position] > prices[i]){
                    stack.pop();
                    answer.set(position, i-position);
                }else{
                    break;
                }
            }
            stack.add(i);
        }
        
        //스택 비우기
        while(!stack.isEmpty()){
            int position = stack.pop();
            answer.set(position, pricesSize-position-1);
        }
        return answer
            .stream()
            .mapToInt(i -> i)
            .toArray();
    }
}

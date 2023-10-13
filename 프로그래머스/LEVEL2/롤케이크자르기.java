import java.util.*;


//O(2n)
class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        HashSet<Integer> leftSet = new HashSet<Integer>();
        Map<Integer, Integer> rightPeiceMap = new HashMap<Integer, Integer>();
        
        
        //전체 조각에 토핑들 개수
        for(int topping : toppings){
            Integer count = rightPeiceMap.get(topping);
            if (count == null) {
                rightPeiceMap.put(topping, 1);
            } else {
                rightPeiceMap.put(topping, count + 1);
            }
        }
        
        //왼쪽부터 하나씩 잘라가면서 개수 파악
        for(int topping : toppings){
            Integer count = rightPeiceMap.get(topping);
            leftSet.add(topping);
            
            if(count == 1){
                rightPeiceMap.remove(topping);
            }else {
                rightPeiceMap.put(topping, count - 1);
            }
            
            if(rightPeiceMap.size() == leftSet.size()) answer++;
            
        }
        
        return answer;
    }
}

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        Assignment[] arr = new Assignment[plans.length];
        for (int i = 0; i < plans.length; i++) {
            Assignment ass = new Assignment(plans[i][0], plans[i][1], plans[i][2]);
            arr[i] = ass;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            return o1.start - o2.start;
        });
        
        Stack<Assignment> stack = new Stack<>();  // 진행 중인 과제
        List<String> answer = new ArrayList<>();    //정답
        
        for (Assignment plan : arr){
            if(stack.isEmpty()){
                stack.push(plan);
                continue;
            }
            
            Assignment newPlan = plan;
            Assignment curPlan = stack.peek();
                
            int curTime = curPlan.start;
            
            while(!stack.isEmpty()){
                curPlan = stack.pop();
                
//                 System.out.print(curTime);
//                 System.out.print(" " + curPlan.name);
//                 System.out.println(" " + newPlan.name);

                if (curTime + curPlan.time <= newPlan.start){
                    answer.add(curPlan.name);
                    curTime += curPlan.time;
                } else {
                    curPlan.time -= newPlan.start - curTime;
                    stack.push(curPlan);
                    break;
                }
            }
            
            stack.push(newPlan);
        }
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        return answer.toArray(new String[0]);
    }
    
    
    static class Assignment {
        private String name;
        private int start;
        private int time;

        public Assignment(String name, String start, String time) {
            this.name = name;
            this.start = timeToMinute(start);
            this.time = Integer.parseInt(time);
        }

        public int timeToMinute(String start) {
            String[] arr = start.split(":");
            int h = Integer.parseInt(arr[0]) * 60;
            int m = Integer.parseInt(arr[1]);
            return h + m;
        }
    }
}


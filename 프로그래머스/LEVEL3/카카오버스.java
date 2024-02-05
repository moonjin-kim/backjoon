import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int arrivedBusCount = 0;
        int arrivedBusTime = TimeToInt("09:00");
        PriorityQueue<Integer> waiters = new PriorityQueue<Integer>();
        
        for(String time : timetable) {
            waiters.add(TimeToInt(time));
        }
        
        while(arrivedBusCount<=n-1){
            if(arrivedBusCount != 0) arrivedBusTime += t;
            int boardCount = 0;
            while(waiters.size()!=0 && boardCount <=m-1){
                if(waiters.peek()>arrivedBusTime)break;
                if(boardCount == m-1 && arrivedBusCount ==n-1) {
                    return answer= TimeToStr(waiters.poll()-1);
                }
                waiters.poll();
                boardCount++;
            }
            arrivedBusCount++;
        }
        return TimeToStr(arrivedBusTime);
    }
    //시간을 숫자로 
     static public int TimeToInt(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return hour*60+min;
    }
    
    //숫자를 시간으로
    static public String TimeToStr(int time){
        String hour = String.format("%02d",time/60);
        String min =  String.format("%02d",time%60);
        return hour+":"+min;
    }
}
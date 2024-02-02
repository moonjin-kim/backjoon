import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int endTime = 0;
        int jobsIdx = 0;
        Arrays.sort(jobs, (num1, num2) -> {
			return Integer.compare(num1[0], num2[0]);
		});
        
        PriorityQueue<Job> minHeap = new PriorityQueue<>();
        while (count < jobs.length) {
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= endTime) {
                minHeap.add(new Job(jobs[jobsIdx][0],jobs[jobsIdx][1]));
                jobsIdx++;
            }
            
            if(minHeap.isEmpty()) {
                endTime = jobs[jobsIdx][0];
            } else {
                Job job = minHeap.poll();
                answer += job.getWorkingTime() + endTime - job.getReqTime();
                endTime +=job.getWorkingTime();
                count++;
            }
        }
        return answer/jobs.length;
    }
}

class Job implements Comparable<Job> {
    int reqTime;
    int workingTime;
    
    public int getReqTime() {
        return this.reqTime;
    }

    public int getWorkingTime() {
        return this.workingTime;
    }
    
    public Job(int reqTime, int workingTime) {
        this.reqTime = reqTime;
        this.workingTime = workingTime;
    }
    
    @Override
    public int compareTo(Job job) {

        if (this.workingTime > job.getWorkingTime())
            return 1;
        else if (this.workingTime < job.getWorkingTime())
            return -1;
        return 0;
    }
}
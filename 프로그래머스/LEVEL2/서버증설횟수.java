class Solution {
    private static final int SERVER_TRACKING_WINDOW_SIZE = 24;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];

        for(int time = 0; time < players.length; time++) {
            int needServerCount = players[time] / m;
            int expansionNum = needServerCount - servers[time];
            if (expansionNum <= 0) {
                continue;
            }

            for(int i = 0; i < k; i++) {
                if(time+i >= SERVER_TRACKING_WINDOW_SIZE) break;
                servers[time+i] += expansionNum;
            }

            answer += expansionNum;
        }

        return answer;
    }
}

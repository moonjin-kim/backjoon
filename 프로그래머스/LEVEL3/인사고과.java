import java.util.*;

/**
 * 정렬 문제
 * 1번로 0번을 내림차수로 정렬하여서 1번 점수가 최대 score보다 작은 경우가 있으면 인센티브를 못받는다
 * 그 후 각 배열의 합으로 내림차순으로 정렬하면 순번이 나온다.
 */
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int size = scores.length;
        int n = scores[0][0];
        int m = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        // 어차피 근무 태도는 내림차순으로 정렬되어 있으므로 동료 점수만 비교하면 됨
        int maxScore = scores[0][1];

        for(int i = 1; i<size; i++) {
            if (scores[i][1] < maxScore) { // 인센티브를 받지 못하는 경우
                if (scores[i][0] == n && scores[i][1] == m) // 완호 점수인 경우
                    return -1;

                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                maxScore = scores[i][1];
            }
        }

        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });

        for(int i = 0; i<size; i++) {
            if (scores[i][0] == n && scores[i][1] == m)
                return i+1;
        }

        return -1;
    }
}

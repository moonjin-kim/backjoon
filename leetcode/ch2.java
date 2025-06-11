/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int prev = 0;
        int idx = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(idx < s.length()) {
            char curn = s.charAt(idx);
            if(!set.contains(curn)) {
                set.add(curn);
                idx++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(prev));
                prev++;
            }
        }

        return max;
    }
}

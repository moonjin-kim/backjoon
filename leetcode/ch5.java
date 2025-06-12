/**
 * Longest Palindromic Substring
 */
class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = getPalindrome(s,i,i);
            if(lps.length() < odd.length()) {
                lps = odd;
            }

            String even = getPalindrome(s,i,i+1);
            if(lps.length() < even.length()) {
                lps = even;
            }
        }

        return lps;
    }

    public String getPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else {
                break;
            }
        }

        return s.substring(left + 1, right);
    }
}

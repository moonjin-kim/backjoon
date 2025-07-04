class Solution {
    public boolean isPalindrome(int n) {
        int[] palindromes = new int[10];
        int len = 0;
        if (n < 0) {
            return false;
        }

        while (n > 0) {
            palindromes[len++] = n % 10;
            x = x /10;
        }

        for (int i = 0; i < len / 2; i++) {
            if (palindromes[i] != palindromes[len - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}

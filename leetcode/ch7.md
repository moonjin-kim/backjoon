# 7. Reverse Integer

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
import java.math.BigInteger;
class Solution {
    public int reverse(int x) {
        long temp = Math.abs((long)x);
        String s = String.valueOf(temp);

        StringBuilder rev = new StringBuilder(s).reverse();
        BigInteger num1 = new BigInteger(rev.toString());

        long res = num1.longValue();
        if (res > Integer.MAX_VALUE || -res < Integer.MIN_VALUE)
            return 0;
        return (x < 0) ? (int) -res : (int) res;
    }
}
```

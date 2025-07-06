# Intuition
투포인터를 이용하여 문제를 해결합니다

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n/2)

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

        # Code
```java []
class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while(left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int extent = width * height;
            max = Math.max(max, extent);

            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
```

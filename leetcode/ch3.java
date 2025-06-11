/**
 * 4. Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr3 = IntStream.concat(
                Arrays.stream(nums1),
                Arrays.stream(nums2)
        ).toArray();

        Arrays.sort(arr3);
        int mid = arr3.length / 2;
        if(arr3.length % 2 == 0) {
            return (double) (arr3[mid] + arr3[mid-1]) / 2;
        } else {
            return (double) arr3[mid];
        }

    }
}

// code bài 1.4.10

public class BinarySearch {
    public static int search(int[] nums, int k) {

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= k) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (left < nums.length && nums[left] == k) {
            return left;
        }
        return -1;
    }
}

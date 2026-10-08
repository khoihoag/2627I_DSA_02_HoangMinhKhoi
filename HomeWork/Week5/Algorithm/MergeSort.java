public class MergeSort {
    public static int[] merge(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        int[] ans = new int[nums1.length + nums2.length];
        int idx = 0;
        while (i< nums1.length && j< nums2.length) {
            if (nums1[i] > nums2[j]) {
                ans[idx] = nums2[j];
                j++;
                idx++;
            } else if (nums1[i] == nums2[j]) {
                ans[idx] = nums1[i];
                ans[idx+1] = nums1[i];

                idx = idx + 2;
                i ++;
                j ++;
            } else {
                ans[idx] = nums1[i];
                idx ++;
                i ++;
            }
        }
        if (i == nums1.length) {
            while (j<nums2.length) {
                ans[idx] = nums2[j];
                j ++;
                idx ++;
            }
        } else if (j == nums2.length) {
            while (i<nums1.length) {
                ans[idx] = nums1[i];
                i ++;
                idx ++;
            }
        }
        return ans;
    }

    public static int[] merge_sort(int[] nums) {
        if (nums.length <= 1){
            return nums;
        }
        int[] num_left = new int[nums.length / 2];
        int i = 0;
        while (i<num_left.length) {
            num_left[i] = nums[i];
            i ++;
        }
        int[] num_right = new int[nums.length-num_left.length];
        int j=0;
        while (j<num_right.length) {
            num_right[j] = nums[i];
            j ++;
            i ++;
        }
        int[] sorted_left = merge_sort(num_left);
        int[] sorted_right = merge_sort(num_right);

        return merge(sorted_left, sorted_right);
    }

    public static void main(String[] args) {
        int[] n= {4, 6, 2, 7, 8, 9, 10};
        int[] ans = merge_sort(n);

        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

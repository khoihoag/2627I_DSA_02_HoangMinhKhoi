// code bài 1.4.8


import java.util.HashMap;
import java.util.Map;


public class Count {
    public static int count (int[] nums) {
         int ans = 0;
         Map<Integer, Integer> dict = new HashMap<>();

         for (int i=0; i < nums.length; i++){
             int num = nums[i];
             if (!dict.containsKey(num)) {
                 dict.put(num, 0);
             }
             dict.put(num, dict.get(num)+1);
         }
         for (int i: dict.keySet()) {
             int value = dict.get(i);
             ans += value * (value - 1) / 2;
         }
         return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,2,2,2};
        System.out.println(count(nums));
    }
}

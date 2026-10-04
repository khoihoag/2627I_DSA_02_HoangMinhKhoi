import java.util.*;

public class InsertionSortPartI {
    public static void insertionSort(List<Integer> nums){

        int res = nums.get(nums.size() - 1);

        int idx = nums.size() - 1;


        for (int j = nums.size() - 2; j >= 0; j--) {

            if (res < nums.get(j)) {


                nums.set(j + 1, nums.get(j));

                idx = j;


                for (int k = 0; k < nums.size(); k++) {
                    System.out.print(nums.get(k) + " ");
                }
                System.out.println();
            }

            if (res > nums.get(j)) {
                break;
            }
        }


        nums.set(idx, res);


        for (int k = 0; k < nums.size(); k++) {
            System.out.print(nums.get(k) + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(2, 5, 6, 3, 1);
        insertionSort(n);
    }
}

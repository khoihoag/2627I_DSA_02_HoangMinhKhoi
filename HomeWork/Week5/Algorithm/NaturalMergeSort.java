import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaturalMergeSort {
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid+1);
        int[] right =  Arrays.copyOfRange(arr, mid+1, end+1);

        int i = 0, j=0;
        int k = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i ++;
            } else {
                arr[k] = right[j];
                j ++;
            }
            k ++;
        }

        if (i == left.length) {
            while (j < right.length) {
                arr[k] = right[j];
                k ++;
                j ++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                System.out.println(i);
                arr[k] = left[i];
                k ++;
                i ++;
            }
        }
    }

    static List<Integer> getRuns(int[] arr) {
        List<Integer> runs = new ArrayList<>();

        for (int i=0; i< arr.length-1; i++) {
             if (arr[i] > arr[i+1]) {
                 runs.add(i);
             }
        }

        runs.add(arr.length - 1);

        return runs;
    }

    static void naturalMerge (int[] arr) {
        while (true) {
            List<Integer> runs = getRuns(arr);

            if (runs.size() == 1) {
                break;
            }

            int i = 0;
            while (i< runs.size()-1) {
                int start = (i ==0) ? 0: runs.get(i-1) + 1;
                int mid = runs.get(i);
                int end = runs.get(i+1);

                merge(arr, start, mid, end);

                i ++;
            }
        }



    }
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 7, 1, 8, 9};
        naturalMerge(a);
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}


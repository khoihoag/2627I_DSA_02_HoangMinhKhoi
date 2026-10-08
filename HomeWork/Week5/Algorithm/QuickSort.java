public class QuickSort {
    public static void partition(int[] num,int left,int right){
        int pivot = num[right];
        int idx = left -1;

        for (int i=left; i<right; i++) {
            if (num[i] < pivot) {
                idx ++;

                int temp = num[i];
                num[i] = num[idx];
                num[idx] = temp;
            }
        }
        int temp = num[idx+1];
        num[idx+1] = num[right];
        num[right] = temp;

        for (int i=0;i<num.length;i++) {
            System.out.print(num[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] n = {4, 3 , 6, 7, 1, 2, 5};
        partition(n, 0, n.length-1);
    }
}

public class bai3 {
    public static void intersection(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                i++;
            }
            else if (a[i] > b[j]) {
                j++;
            }
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 3, 5, 8, 9};

        intersection(a, b);
    }
}
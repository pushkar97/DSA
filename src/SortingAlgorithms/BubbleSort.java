package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 1; j <= i; j++) {
                if (a[j-1] > a[j]) {
                    swapped = true;
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
            if(!swapped) break;
        }
    }

    public void bubbleSortRecursive(int[] a, int n) {
        if (n == 1) return;
        for (int j = 1; j < n; j++)
            if (a[j-1] > a[j]) {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        bubbleSortRecursive(a, n-1);
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] a = new int[]{3,1,6,2,5,4};
//        b.bubbleSort(a);
        b.bubbleSortRecursive(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}

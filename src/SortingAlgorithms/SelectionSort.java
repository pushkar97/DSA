package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int min = i-1;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int temp = a[min];
            a[min] = a[i-1];
            a[i-1] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] a = new int[]{3,1,6,2,5,4};
        s.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}

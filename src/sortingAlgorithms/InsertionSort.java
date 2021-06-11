package sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0)
                if (temp < a[j-1]) a[j] = a[--j];
                else { break;}
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort b = new InsertionSort();
        int[] a = new int[]{3,1,6,2,5,4};
        b.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}

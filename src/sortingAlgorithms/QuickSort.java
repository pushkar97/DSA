package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] a) {
        quickSortHelper(a, 0, a.length);
    }

    private void quickSortHelper(int[] a, int start, int end) {
        if (start >= end) return;
        int pivot = a[end-1];
        int i = start;
        int j = end-2;
        while (i<j){
            while(a[i] < pivot) i++;
            while(a[j] > pivot) j--;
            if(i < j) swap(a, i, j);
            else swap(a,i, end-1);
        }
        quickSortHelper(a, start, i);
        quickSortHelper(a, i+1, end);
    }
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = new int[]{3,1,6,2,5,4};
        q.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}

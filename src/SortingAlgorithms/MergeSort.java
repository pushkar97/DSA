package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] a) {
        return mergeSortHelper(a, 0, a.length);
    }

    public int[] mergeSortHelper(int[] a, int i, int j) {
        if (j - i <= 1) return new int[]{a[i]};
        int mid = (i+j)/2;
        int[] p = mergeSortHelper(a, i, mid);
        int[] q = mergeSortHelper(a, mid, j);
        int pc = 0, qc = 0, k = 0;
        int[] out = new int[j-i];
        while(pc < p.length && qc < q.length)
            if(p[pc] < q[qc]) out[k++] = p[pc++];
            else out[k++] = q[qc++];
        if(pc == p.length)
            while (qc < q.length) out[k++] = q[qc++];
        if(qc == q.length)
            while (pc < p.length) out[k++] = p[pc++];
        return out;
    }

    public static void main(String[] args) {
        MergeSort q = new MergeSort();
        int[] a = new int[]{3,1,6,2,5,4};
        System.out.println(Arrays.toString(q.mergeSort(a)));
    }
}

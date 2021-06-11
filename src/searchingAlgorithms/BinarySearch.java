package searchingAlgorithms;

public class BinarySearch {

    public int binarySearchIterative(int[] a, int target) {
        int start = 0; int end = a.length;
        while (start<end) {
            int mid = (start+end)/2;
            if(a[mid] == target) return mid;
            if (a[mid] > target) end = mid;
            else start = mid+1;
        }
        return -1;
    }

    public int binarySearchRecursive(int[] a, int target, int start, int end) {
        int mid = (start+end)/2;
        if(mid == end) return -1;
        if (a[mid] == target) return mid;
        if (target < a[mid]) return binarySearchRecursive(a, target, start, mid);
        else return binarySearchRecursive(a, target, mid+1, end);
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] input = new int[] {1,2,4,6,8,10,13,25,33,47,55,58,63,71};
        int target = 72;
        System.out.println(b.binarySearchIterative(input,target));
        System.out.println(b.binarySearchRecursive(input, target, 0, input.length));
    }
}

package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Q: find element from given array of length n which is present more than n/2 times
public class MajorityElements {

    //will go to each element and check for its count in remaining array,
    //once counting is complete will check if it's majority element or not
    // T: O(N^2)
    // S: O(1)
    public int bruteForce(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            for (int j = i + 1; j < a.length; j++) if(a[i] == a[j]) count++;
            if(count > a.length/2) return a[i];
        }
        return -1;
    }

    //sorts an array and checks for count of consecutive elements
    // T: O(N*logN)
    // S: O(1)
    public int sorting(int[] a) {
        Arrays.sort(a);
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i] == a[i-1]) {
                count++;
                if(count > a.length/2) return a[i];
            }
            else count = 1;
        }
        return -1;
    }

    // Uses hashmap to store element count
    // T: O(N)
    // S: O(N)
    public int usingExtraSpace(int[] a) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : a) {
            if(count.containsKey(i)) {
                int newCount = count.get(i) + 1;
                if(newCount > a.length/2){return i;}
                count.put(i, newCount);}
            else count.put(i,1);
        }
        return -1;
    }

    //as the majority element is more than the half the size of array it will have positive count after first counting
    //second loop makes sure that the element we found is actually a majority element
    // T: O(N)
    // S: O(1)
    public int mooresVotingAlgo(int[] a) {
        int element = a[0];
        int count = 0;
        for (int i : a){
            if(i == element) count++;
            else count --;
            if(count == 0) element = i;
        }
        count = 0;
        for (int i : a) if(i == element) count++;
        if(count > a.length/2) return element;
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,1,2,1,2,1,1}; //length : 8
        MajorityElements p = new MajorityElements();
        System.out.println("Brute force : " + p.bruteForce(input));
        System.out.println("Sorting : " + p.sorting(input));
        System.out.println("Extra space : " + p.usingExtraSpace(input));
        System.out.println("Moore's voting algo : " + p.mooresVotingAlgo(input));
    }
}

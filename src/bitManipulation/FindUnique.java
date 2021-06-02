package bitManipulation;

import java.util.HashMap;
import java.util.Map;

//P: find unique element from input array in which each element appears twice except the unique element
public class FindUnique {

    //runs double for loop and checks for each element if it appears somewhere else in an array
    //T: O(N^2)
    //S: O(1)
    public int bruteForce(int[] a) {
        for(int i = 0; i < a.length; i++){
            boolean found = false;
            for (int j = 0; (j < a.length); j++)
                if(j != i && a[j] == a[i]) {found = true; break;}
            if (!found) return a[i];
        }
        return -1;
    }

    //counts occurrence of each element and stores in a hashmap, and checks for element with 1 occurrence.
    //T: O(N)
    //S: O(N)
    public int extraSpace(int[] a) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i : a)
            if (counter.containsKey(i)) counter.put(i, counter.get(i) + 1);
            else counter.put(i, 1);
        for (Map.Entry<Integer, Integer> e : counter.entrySet())
            if (e.getValue() == 1) return e.getKey();
        return -1;
    }

    //uses xor property : N ^ N = 0 | N ^ 0 = N, same elements in the array cancel each other,
    //unique element remains at the end.
    //T: O(N)
    //S: O(1)
    public int xor(int[] a) {
        int ans = 0;
        for (int i : a) ans ^= i;
        return ans;
    }
}

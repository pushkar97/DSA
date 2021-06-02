package bitManipulation;

import java.util.HashMap;
import java.util.Map;

//P: find 2 unique elements from given array which contains each element twice except 2 unique elements.
public class FindUnique2 {

    //runs double for loop and checks for each element if it appears somewhere else in an array
    //T: O(N^2)
    //S: O(1)
    public int[] bruteForce(int[] a) {
        int[] ans = new int[2];
        int k = 0;
        for(int i = 0; i < a.length; i++){
            boolean found = false;
            for (int j = 0; (j < a.length); j++)
                if(j != i && a[j] == a[i]) {found = true; break;}
            if (!found) ans[k++] =  a[i];
        }
        return ans;
    }

    //counts occurrence of each element and stores in a hashmap, and checks for element with 1 occurrence.
    //T: O(N)
    //S: O(N)
    public int[] extraSpace(int[] a) {
        Map<Integer, Integer> counter = new HashMap<>();
        int[] ans = new int[2];
        int k = 0;
        for(int i : a)
            if (counter.containsKey(i)) counter.put(i, counter.get(i) + 1);
            else counter.put(i, 1);
        for (Map.Entry<Integer, Integer> e : counter.entrySet())
            if (e.getValue() == 1) ans[k++] = e.getKey();
        return ans;
    }

    //finds xor of 2 unique elements, finds least sig bit of that and uses that to separate 2 elements in different group
    //in input array.
    //T: O(N)
    //S: O(1)
    public int[] enhancedXor(int[] a) {
        FindUnique f = new FindUnique();
        FindLeastSignificantSetBit s = new FindLeastSignificantSetBit();
        int num = f.xor(a);
        int b = s.leastSignificantSetBit(num);
        int[] ans = new int[]{0,0};
        for (int i : a) if ((i & (1<<b)) > 0) ans[0] ^=i;
        ans[1] = num ^ ans[0];
        return ans;
    }
}

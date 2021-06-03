package mathAndNumberTheory;

import java.util.Arrays;

public class SieveOfEratosthenes {

    // P: Find if number is prime.
    // Uses property : for number a, if it has no factors till square root a then number is prime number.
    public boolean isPrime(int a) {
        for (int i = 2; i * i < a; i++)
            if (a%i==0) return false;
        return true;
    }

    //Returns a boolean array for range a where element at i th index is true if number is prime
    public boolean[] sieveOfEratosthenes(int a) {
        boolean[] ans = new boolean[a+1];
        Arrays.fill(ans, 2, ans.length, true);
        for (int i = 2; i * i <= a; i++)
            if (ans[i])
                for (int j = i << 1; j <= a; j += i)
                    ans[j] = false;
        return ans;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes s = new SieveOfEratosthenes();
        System.out.println("Is Prime : " + s.isPrime(17));
        System.out.println("--- SieveOfEratosthenes ---");
        boolean[] ans = s.sieveOfEratosthenes(1000);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(i+":\t\t:"+ans[i]);
        }
    }
}

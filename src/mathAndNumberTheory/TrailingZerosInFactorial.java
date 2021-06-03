package mathAndNumberTheory;
//P: find number of trailing zeros in factorial of number a
public class TrailingZerosInFactorial {

    //There are as many number of zeros as many pair of 5 and 2. also count of 2 will always be more than 5.
    // Thus we have to only find the count of 5 in the factorial series.
    //final formula is :  a/5 + a/25 + a/125 ...
    public int trailingZerosCount(int a) {
        int count = 0;
        for (int i = 5; i <= a; i*=5) count += a/i;
        return count;
    }
}

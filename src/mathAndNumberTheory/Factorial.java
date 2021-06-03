package mathAndNumberTheory;
//P: find factorial of given number a
public class Factorial {

    public long iterative(long a) {
        long ans = 1;
        for (int i = 2; i <= a; i++) ans *= i;
        return ans;
    }

    public long recursive(long a) {
        if(a == 0) return 1;
        return a * recursive(a-1);
    }
}

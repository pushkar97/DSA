package mathAndNumberTheory;
//P: Find power b of a number 'a'
public class Power {

    public long iterative(long a, long b) {
        long ans = 1;
        for(int i = 1; i <= b; i++) ans*=a;
        return ans;
    }

    public long recursive(long a, long b) {
        if(b == 0) return 1;
        return a * recursive(a, b-1);
    }

    public long fastPowerIterative(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if((b&1) == 1) ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }

    public long fastPowerRecursive(long a, long b) {
        if(b == 0) return 1;
        if((b&1) == 1)
            return a * fastPowerRecursive(a, b-1);
        return fastPowerRecursive(a*a, b/2);
    }

    public static void main(String[] args) {
        Power p = new Power();
        int a = 3;
        int b = 1;
        System.out.println("iterative : " + p.iterative(a,b));
        System.out.println("recursive : " + p.recursive(a,b));
        System.out.println("fastPowerIterative : " + p.fastPowerIterative(a,b));
        System.out.println("fastPowerRecursive : " + p.fastPowerRecursive(a,b));
    }
}

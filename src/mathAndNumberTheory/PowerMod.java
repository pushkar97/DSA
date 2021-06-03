package mathAndNumberTheory;
//P: find a^b mod n
public class PowerMod {

    //uses property: a * b mod n = (a % n * b % n) % n;
    public long fastPowerModIterative(long a, long b, long n) {
        long ans = 1;
        while (b > 0) {
            if((b&1) == 1) ans = (ans * (a%n))%n;
            a = (a%n * a%n) % n;
            b >>= 1;
        }
        return ans;
    }

    public long fastPowerModRecursive(long a, long b, long n) {
        if(b == 0) return 1;
        if((b&1) == 1)
            return (a % n * fastPowerModRecursive(a % n, b-1, n)) % n;
        return fastPowerModRecursive((a % n * a % n) % n, b/2, n);
    }

    public static void main(String[] args) {
        PowerMod pm = new PowerMod();
        int a = 356, b = 13, n = 91;
        System.out.println("fastPowerModIterative : " + pm.fastPowerModIterative(a,b,n));
        System.out.println("fastPowerModRecursive : " + pm.fastPowerModRecursive(a,b,n));
    }
}

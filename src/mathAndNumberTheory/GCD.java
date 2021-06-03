package mathAndNumberTheory;
//P: find a greatest common divisor of 2 numbers a,b
public class GCD {

    public int gcdIterative(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int gcdRecursive(int a, int b) {
        if(b == 0) return a;
        return gcdRecursive(b, a%b);
    }

    public static void main(String[] args) {
        GCD g = new GCD();
        int a = 72, b = 256;
        System.out.println("GcdIterative : " + g.gcdIterative(a, b));
        System.out.println("GcdRecursive : " + g.gcdRecursive(a, b));
    }
}
package bitManipulation;
//P: return true if number is even else false
public class IsEven {

    public boolean arithmeticOperator(int a) {
        return a % 2 == 0;
    }

    //masks last bit and checks if it is 1 or 0
    public boolean bitOperator(int a) {
        return (a & 1) == 0;
    }
}

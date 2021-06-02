package bitManipulation;
//P: Count number of set bits in given integer
public class CountSetBits {

    //uses property: n & (n-1) clears least sig bit
    public int bitMagic(int a) {
        int count = 0;
        while(a != 0) {
            a&=a-1;
            count++;
        }
        return count;
    }
}

package bitManipulation;

public class FindLeastSignificantSetBit {

    public int leastSignificantSetBit(int a){
        for (int i = 0; i < 32; i++)
            if((a & (1 << i)) != 0) return i;
        return -1;
    }

    public static void main(String[] args) {
        FindLeastSignificantSetBit p = new FindLeastSignificantSetBit();
        System.out.println("Least significant bit position : "+p.leastSignificantSetBit(4));
        System.out.println("Least significant bit position : "+p.leastSignificantSetBit(5));
        System.out.println("Least significant bit position : "+p.leastSignificantSetBit(Integer.MIN_VALUE));
    }
}

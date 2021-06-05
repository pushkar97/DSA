package recursion;

public class IsSubsequence {

    public boolean isSubsequence(char[] str1, char[] str2, int m, int n){
        if (n == str2.length) return true;
        if(m == str1.length) return false;
        if(str1[m] == str2[n]) return isSubsequence(str1, str2, m+1, n+1);
        return isSubsequence(str1, str2, m+1, n);
    }
}

package backTracking;

import java.util.Arrays;

public class NQueen {
    public boolean[][] nQueen(int n) {
        boolean[][] out = new boolean[n][n];
        nQueenHelper(out, 0);
        return out;
    }

    private boolean nQueenHelper(boolean[][] out, int row) {
        if (row >= out.length) return true;
        for (int j = 0; j < out.length; j++) {
            if(isSafe(out, row, j)){
                out[row][j] = true;
                if(nQueenHelper(out, row + 1)) return true;
                out[row][j] = false;
            }
        }
        return false;
    }

    private boolean isSafe(boolean[][] canvas, int i, int j) {
        for (int k = 0; k < canvas.length; k++)
            if(canvas[k][j]) return false;
        int k = i, l = j;
        while (k > 0 && l > 0){
            if (canvas[--k][--l]) return false;
        }
        k = i; l = j;
        while (k > 0 && l < canvas.length-1){
            if (canvas[--k][++l]) return false;
        }
        k = i; l = j;
        while (k < canvas.length-1 && l < canvas.length-1){
            if (canvas[++k][++l]) return false;
        }
        k = i; l = j;
        while (k < canvas.length-1 && l > 0){
            if (canvas[++k][--l]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen q = new NQueen();
        boolean[][] ans = q.nQueen(4);
        for (boolean[] an : ans) {
            System.out.println(Arrays.toString(an));
        }

    }
}

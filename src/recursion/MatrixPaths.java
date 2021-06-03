package recursion;

//P: Find number of paths in a matrix from top left corner to bottom right corner.
// step can only be in right and bottom direction
public class MatrixPaths {

    //E: there exists only one path if either there is only 1 column or 1 row in matrix,
    // irrespective of number of rows & columns
    //we are taking recursive leap of faith here for both of above cases. and adding the result
    public int paths(int rows, int columns) {
        if(rows == 1 || columns == 1) return 1;
        return paths(rows, columns - 1) + paths(rows - 1, columns);
    }

    public static void main(String[] args) {
        MatrixPaths m = new MatrixPaths();
        System.out.println(m.paths(2,4));
    }
}

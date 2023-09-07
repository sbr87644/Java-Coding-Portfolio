
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] mat;
    private int size, openSites;
    private WeightedQuickUnionUF site, checkFull;

    public Percolation(int n) { // create n-by-n grid, with all sites blocked
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        mat = new boolean[n][n];
        site = new WeightedQuickUnionUF(n * n + 2);
        checkFull = new WeightedQuickUnionUF(n * n + 1);
    }

    public void open(int row, int col) { // open site (row, col) if it is not open already
        if (!isOpen(row, col)) {
            openSites++;
            row--;
            col--;
            checkRange(row, col);
            mat[row][col] = true;
            int ID = getID(row, col);
            if (row == 0) {
                site.union(0, ID);
                checkFull.union(0, ID);
            }
            if (row == size - 1) {
                site.union(size * size + 1, ID);
            }
            if (inBounds(row + 1) && mat[row + 1][col]) {
                site.union(ID, getID(row + 1, col));
                checkFull.union(ID, getID(row + 1, col));
            }
            if (inBounds(col + 1) && mat[row][col + 1]) {
                site.union(ID, getID(row, col + 1));
                checkFull.union(ID, getID(row, col + 1));
            }
            if (inBounds(row - 1) && mat[row - 1][col]) {
                site.union(ID, getID(row - 1, col));
                checkFull.union(ID, getID(row - 1, col));
            }
            if (inBounds(col - 1) && mat[row][col - 1]) {
                site.union(ID, getID(row, col - 1));
                checkFull.union(ID, getID(row, col - 1));
            }
        }
    }

    private boolean inBounds(int n) {
        return n < size && n >= 0;
    }

    private int getID(int r, int c) {			// helper method to calculate ID
        return r * size + c + 1;
    }

    public boolean isOpen(int row, int col) { // is site (row, col) open?  
        checkRange(--row, --col);
        return mat[row][col];
    }

    public boolean isFull(int row, int col) { // is site (row, col) full?
        checkRange(--row, --col);
        return checkFull.find(getID(row, col)) == checkFull.find(0);
    }

    private void checkRange(int row, int col) {	// validate input
        if (row >= size || col >= size || row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean percolates() { // does the system percolate?
        return site.find(0) == site.find(size * size + 1);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    private void print() { // prints boolean[][] called mat
        /*for(boolean[] row: mat){
   		for(boolean col: row){
   			System.out.print((col ? 1: 0) + " ");
   		}
   		System.out.println();
   	}
   	System.out.println();*/
    }

    public static void main(String[] args) // test client (optional){
    {
        Percolation test = new Percolation(2);	// simple test case
        test.print();
        test.open(1, 1);
        test.print();
        test.open(2, 1);
        test.print();
        System.out.println(test.percolates());
    }
}

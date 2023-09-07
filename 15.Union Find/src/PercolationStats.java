
//import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private double[] trials;

    public PercolationStats(int n, int t) { // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException();
        }
        trials = new double[t];
        for (int i = 0; i < t; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = (int) (Math.random() * n);
                int col = (int) (Math.random() * n);
                if (!perc.isOpen(row + 1, col + 1)) {
                    perc.open(row + 1, col + 1);
                }
            }
            trials[i] = (double) perc.numberOfOpenSites() / (double) (n * n);
        }
    }

    public double mean() { // sample mean of percolation threshold
        return StdStats.mean(trials);
    }

    public double stddev() { // sample standard deviation of percolation threshold
        return StdStats.stddev(trials);
    }

    public double confidenceLo() { // low  endpoint of 95% confidence interval
        return mean() - (1.96 * stddev()) / Math.sqrt(trials.length);
    }

    public double confidenceHi() { // high endpoint of 95% confidence interval
        return mean() + (1.96 * stddev()) / Math.sqrt(trials.length);
    }

    public static void main(String[] args) { // test client (described below)
        int n = Integer.parseInt(args[0]);         // n-by-n percolation system
        int T = Integer.parseInt(args[1]);		 	// T trials
        PercolationStats ps = new PercolationStats(n, T);
//        out.println("mean                    = " + ps.mean());
//        out.println("stddev                  = " + ps.stddev());
//        out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}

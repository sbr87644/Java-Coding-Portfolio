
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.*;

public class Job {
      
    public static void main(String[] args) throws FileNotFoundException{
        Scanner file = new Scanner(new File("jobs.txt"));
        int numJobs = file.nextInt();
        JobInfo[] jobs = new JobInfo[numJobs];
        for(int i = 0; i < numJobs; i++){
            jobs[i] = new JobInfo(file.nextInt(), file.nextInt());
        }
        Arrays.sort(jobs);
        
        long sumLength = 0, sum = 0;
        for(int i = 0; i < jobs.length; i++){
           sumLength+= jobs[i].l;
           sum+= (jobs[i].w * sumLength);
        }
        out.println(sum);
    }
    
    private static class JobInfo implements Comparable{
        
        double w, l;
        
        public JobInfo(int weight, int length){
            w = weight;
            l = length;
        }

        public int compareTo(Object t) {
            JobInfo j = (JobInfo) t;
            return Double.compare(j.w/j.l, w/l);
        }
        
    }
}

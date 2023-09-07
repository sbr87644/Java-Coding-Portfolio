
import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        int[] lines = new int[points.length];
        int minEnd = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE;
        int count = 0, index = 0;
        for (int i = 0; i < points.length; i += 2) {
            if (points[i + 1] > maxEnd) {
                maxEnd = points[i + 1];
            }
            if (points[i + 1] < minEnd) {
                minEnd = points[i + 1];
            }
            if (points[i] >= minEnd) {
                lines[index++] = minEnd;
                count++;
                minEnd = points[i + 1];
            }
        }
        if (maxEnd > minEnd && lines[index - 1] != minEnd) {
            lines[index++] = minEnd;
            count++;
        }
        int[] finalLines = new int[count];
        System.arraycopy(lines, 0, finalLines, 0, count);
        return finalLines;
    }

    private static class Segment {

        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        
    }
}

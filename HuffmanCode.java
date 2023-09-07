
import java.io.PrintStream;
import java.util.*;

public class HuffmanCode {

    Map<String, Character> codes;
    Queue<HuffmanNode> pq;

    public HuffmanCode(Scanner in) {
        codes = new HashMap();
        char ch;
        String c;
        while(in.hasNextLine()){
             ch = (char) in.nextInt();
             in.nextLine();
             c = in.nextLine();
             codes.put(c, ch);
        }
    }

    public HuffmanCode(int[] cnt) {
        pq = new PriorityQueue();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                pq.add(new HuffmanNode((char) i, cnt[i]));
            }
        }
        
        while(pq.size() > 1){
            HuffmanNode h1 = pq.poll();
            HuffmanNode h2 = pq.poll();
            
            HuffmanNode combine = new HuffmanNode((char) 0, h1.freq + h2.freq, h1, h2);
            pq.add(combine);
        }
    }

    public void translate(BitInputStream in, PrintStream out) {
        String bit;
        while(in.hasNextBit()){
            bit = "";
            while(!codes.containsKey(bit)){
              if(in.hasNextBit()){   
                  bit+= in.nextBit();
              }
            }
            out.print(codes.get(bit));
        }
        out.close();
    }

    public void save(PrintStream out) {
        HuffmanNode root = pq.peek();
        save(root, "", out);
        out.close();
    }
    
    private void save(HuffmanNode node, String code, PrintStream out){
        if(node != null){
             save(node.left, code + "0", out);
             if(node.ch != (char) 0){
                  out.println((int) node.ch);
                  out.println(code);
             }
             save(node.right, code + "1", out);
        }
    }

    public class HuffmanNode implements Comparable {

        char ch;
        int freq;
        HuffmanNode left, right;

        public HuffmanNode(char c, int f) {
            ch = c;
            freq = f;
        }
        
        public HuffmanNode(char c, int f, HuffmanNode l, HuffmanNode r) {
            ch = c;
            freq = f;
            left = l;
            right = r;
        }

        public int compareTo(Object o) {
            HuffmanNode other = (HuffmanNode) o;
            return Integer.compare(freq, other.freq);
        }
    }
}

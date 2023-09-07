
import java.util.Map;
import java.util.TreeMap;

public class GuitarHero {

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        Map<String, GuitarString> strings = new TreeMap<>();
        int index = 0;
        for (char c : keyboard.toCharArray()) {
            String s = c + "";
            strings.put(s, new GuitarString(440 * Math.pow(1.05956, index - 24)));
            index++;
        }
        play(strings);
    }

    private static void play(Map<String, GuitarString> strings) {
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                String key = StdDraw.nextKeyTyped() + "";
                if (strings.containsKey(key)) {
                    strings.get(key).pluck();
                }
            }

            double sample = 0;
            for (String key : strings.keySet()) {
                sample += strings.get(key).sample();
                strings.get(key).tic();
            }
            StdAudio.play(sample);
        }
    }

}

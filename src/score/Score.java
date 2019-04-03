package score;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static Map<String, Long> scores = new HashMap<>();

    public static void addToScores(String name, long score) {
        System.out.println(name + " | " + score);
        scores.put(name, score);
    }

    public static long getFromScores(String name) {
        return scores.get(name);
    }


}

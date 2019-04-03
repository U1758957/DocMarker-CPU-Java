package score;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static Map<String, Integer> scores = new HashMap<>();

    public static void addToScores(String name, int score) {
        scores.put(name, score);
    }

    public static int getFromScores(String name) {
        return scores.get(name);
    }


}

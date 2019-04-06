package score;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static Map<String, Long> scores = new HashMap<>();

    /**
     * Add to the score dictionary
     *
     * @param name  the name of the benchmark (the key)
     * @param score the score to add (the value)
     */
    public static void addToScores(String name, long score) {
        System.out.println(name + " | " + score);
        scores.put(name, score);
    }

    /**
     * Get a score from the dictionary
     * @param name the name of the benchmark you want the score of (the key)
     * @return the score (the value)
     */
    public static long getFromScores(String name) {
        return scores.get(name);
    }


}

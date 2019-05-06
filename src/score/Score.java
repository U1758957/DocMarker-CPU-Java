package score;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static Map<String, Double> scores = new HashMap<>();

    /**
     * Add to the score dictionary
     *
     * @param name  the name of the benchmark (the key)
     * @param score the score to add (the value)
     */
    public static void addToScores(String name, double score) {
        System.out.println(name + " | " + score);
        scores.put(name, score);
    }

    /**
     * Get a score from the dictionary
     * @param name the name of the benchmark you want the score of (the key)
     * @return the score (the value)
     */
    public static double getFromScores(String name) {
        return scores.get(name);
    }


}

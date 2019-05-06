package score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private static Map<String, Double> scores = new HashMap<>();
    private static List<String> names = new ArrayList<>();

    /**
     * Add to the score dictionary
     *
     * @param name  the name of the benchmark (the key)
     * @param score the score to add (the value)
     */
    public static void addToScores(String name, double score) {
        scores.put(name, score);
        names.add(name);
    }

    /**
     * Get a score from the dictionary
     * @param name the name of the benchmark you want the score of (the key)
     * @return the score (the value)
     */
    public static double getFromScores(String name) {
        return scores.get(name);
    }

    static List<String> getNames() {
        return names;
    }
}

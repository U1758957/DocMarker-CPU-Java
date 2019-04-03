package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class Decompression implements Benchmark {

    private static Timer timer = new Timer();

    private int benchPoints;

    public Decompression(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Decompression";
    }

    @Override
    public int runTest() {
        return 0;
    }

    @Override
    public void setScore(int score) {
        Score.addToScores(getName(), score);
    }
}

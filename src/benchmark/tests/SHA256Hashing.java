package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SHA256Hashing implements Benchmark {

    private static Timer timer = new Timer();

    private int benchPoints;

    public SHA256Hashing(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "SHA-256 Hashing";
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

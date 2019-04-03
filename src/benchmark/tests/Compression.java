package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class Compression implements Benchmark {

    private static Score score = new Score();
    private static Timer timer = new Timer();

    private int benchPoints;

    public Compression(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Compression";
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

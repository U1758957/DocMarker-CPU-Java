package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SHA256Hashing implements Benchmark {

    private long benchPoints;

    public SHA256Hashing(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "SHA-256 Hashing";
    }

    @Override
    public long runTest() {
        Timer.startTiming();
        return (long) (benchPoints / Timer.endTiming());
    }

    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}

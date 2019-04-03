package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class MD5Hashing implements Benchmark {

    private long benchPoints;

    public MD5Hashing(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "MD5 Hashing";
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

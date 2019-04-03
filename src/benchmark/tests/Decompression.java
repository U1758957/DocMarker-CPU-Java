package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class Decompression implements Benchmark {

    private long benchPoints;

    public Decompression(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Decompression";
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

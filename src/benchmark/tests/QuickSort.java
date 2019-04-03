package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class QuickSort implements Benchmark {

    private long benchPoints;

    public QuickSort(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Quick Sort";
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

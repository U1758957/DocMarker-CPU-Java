package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SelectionSort implements Benchmark {

    private long benchPoints;

    public SelectionSort(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Selection Sort";
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

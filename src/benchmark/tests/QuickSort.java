package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class QuickSort implements Benchmark {

    private long benchPoints;
    private int[] array;

    public QuickSort(long benchPoints, int[] array) {
        this.benchPoints = benchPoints;
        this.array = array;
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

package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SelectionSort implements Benchmark {

    private long benchPoints;
    private int[] array;

    public SelectionSort(long benchPoints, int[] array) {
        this.benchPoints = benchPoints;
        this.array = array;
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

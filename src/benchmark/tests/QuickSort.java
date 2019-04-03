package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class QuickSort implements Benchmark {

    private static Timer timer = new Timer();

    private int benchPoints;

    public QuickSort(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "Quick Sort";
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

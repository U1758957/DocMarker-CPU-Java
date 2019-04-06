package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class Decompression implements Benchmark {

    private long benchPoints;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     */
    public Decompression(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    /**
     * Get the name of this test
     * @return the name of the test
     */
    @Override
    public String getName() {
        return "Decompression";
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        Timer.startTiming();
        return (long) (benchPoints / Timer.endTiming());
    }

    /**
     * Store the score in the Score buffer class
     * @param score the score to set
     */
    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}

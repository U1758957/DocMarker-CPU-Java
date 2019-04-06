package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SHA256Hashing implements Benchmark {

    private long benchPoints;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     */
    public SHA256Hashing(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public String getName() {
        return "SHA-256 Hashing";
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

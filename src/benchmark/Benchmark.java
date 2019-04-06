package benchmark;

public interface Benchmark {

    /**
     * Starts the benchmark
     *
     * @return the score of that test
     */
    long runTest();

    /**
     * Store the score in the Score buffer class
     * @param score the score to set
     */
    void setScore(long score);

    /**
     * Get the name of this test
     * @return the name of the test
     */
    String getName();

}

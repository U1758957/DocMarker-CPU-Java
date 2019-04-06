package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class SelectionSort implements Benchmark {

    private long benchPoints;
    private int[] array;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     * @param array       the array to sort
     */
    public SelectionSort(long benchPoints, int[] array) {
        this.benchPoints = benchPoints;
        this.array = array;
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public String getName() {
        return "Selection Sort";
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        Timer.startTiming();
        int arrayLength = array.length;
        if (arrayLength > 1) {
            int minValueIndex;
            int temp;
            for (int current = 0; current < arrayLength; current++) {
                minValueIndex = current;
                for (int swapIndex = current + 1; swapIndex < arrayLength; swapIndex++) {
                    if (array[minValueIndex] > array[swapIndex]) {
                        minValueIndex = swapIndex;
                    }
                }
                if (minValueIndex != current) {
                    temp = array[current];
                    array[current] = array[minValueIndex];
                    array[minValueIndex] = temp;
                }
            }
        }
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

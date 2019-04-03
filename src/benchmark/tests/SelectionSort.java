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

    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}

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

    private void sortArray(int[] array, int left, int right) {
        if (left < right) {
            int tempL = left;
            int tempR = right;
            int temp;
            int pivot = array[(tempL + tempR) / 2];
            do {
                while (array[tempL] < pivot) {
                    tempL++;
                }
                while (array[tempR] > pivot) {
                    tempR--;
                }
                if (tempL <= tempR) {
                    temp = array[tempL];
                    array[tempL] = array[tempR];
                    array[tempR] = temp;
                    tempL++;
                    tempR--;
                }
            } while (tempL <= tempR);
            sortArray(array, left, tempR);
            sortArray(array, tempL, right);
        }
    }

    @Override
    public long runTest() {
        Timer.startTiming();

        int arrLength = array.length;

        if (arrLength > 1) {
            int right = arrLength - 1;
            int left = 0;
            sortArray(array, left, right);
        }

        return (long) (benchPoints / Timer.endTiming());
    }

    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}

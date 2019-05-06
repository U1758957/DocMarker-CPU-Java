package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class HeapSort implements Benchmark {

    private long benchPoints;
    private int[] array;

    public HeapSort(long benchPoints, int[] array) {
        this.benchPoints = benchPoints;
        this.array = array;
    }

    private void turnToHeaps(int[] array, int end, int count) {

        int root = count;
        int left = (2 * count) + 1;
        int right = (2 * count) + 2;

        int tempValue;

        if (left < end && array[left] > array[root]) {
            root = left;
        }

        if (right < end && array[right] > array[root]) {
            root = right;
        }

        if (root != count) {
            tempValue = array[count];
            array[count] = array[root];
            array[root] = tempValue;
            turnToHeaps(array, end, root);
        }

    }

    private void sortArray() {
        int arrLength = array.length;
        if (arrLength > 1) {
            int tempValue;
            for (int count = ((arrLength / 2) - 1); count >= 0; count--) {
                turnToHeaps(array, arrLength, count);
            }
            for (int count = arrLength - 1; count >= 0; count--) {
                tempValue = array[0];
                array[0] = array[count];
                array[count] = tempValue;
                turnToHeaps(array, count, 0);
            }
        }
    }

    @Override
    public long runTest() {
        Timer.startTiming();
        sortArray();
        return (long) (benchPoints / Timer.endTiming());
    }

    @Override
    public void setScore(double score) {
        Score.addToScores(getName(), score);
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }
}

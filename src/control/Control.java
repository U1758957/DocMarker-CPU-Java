package control;

import benchmark.Benchmark;
import benchmark.tests.*;
import score.Score;

public class Control {

    private long benchPoints;

    /**
     * The constructor for Control
     *
     * @param benchPoints the score divisor
     */
    public Control(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    /**
     * Manages testing for the benchmarks. Initialises them, runs them, calculates the final scores, and saves.
     */
    public void manageTesting() {

        Benchmark[] benchmarks = new Benchmark[8];
        long finalScore = 0;

        Data data = new Data(benchPoints > Integer.MAX_VALUE - 1 ? Integer.MAX_VALUE : Math.toIntExact(benchPoints));

        benchmarks[0] = new AESEncryption(benchPoints);
        benchmarks[1] = new Compression(benchPoints);
        benchmarks[2] = new Decompression(benchPoints);
        benchmarks[3] = new MD5Hashing(benchPoints);
        benchmarks[4] = new SHA256Hashing(benchPoints);
        benchmarks[5] = new SHA512Hashing(benchPoints);
        benchmarks[6] = new SelectionSort(benchPoints, data.getNewArray());
        benchmarks[7] = new QuickSort(benchPoints, data.getNewArray());

        for (Benchmark benchmark : benchmarks) {
            System.out.println("Running " + benchmark.getName());
            benchmark.setScore(benchmark.runTest());
            finalScore += Score.getFromScores(benchmark.getName());
        }

        finalScore /= benchmarks.length;

        Score.addToScores("Final Score", finalScore);

    }

}

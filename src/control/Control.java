package control;

import benchmark.Benchmark;
import benchmark.tests.*;
import score.Save;
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

        System.out.println("Preparing..." + System.lineSeparator());

        Benchmark[] benchmarks = new Benchmark[8];
        double finalScore = 0;
        double currentScore = 0;
        int testCounter = 0;

        Data data = new Data(benchPoints > Integer.MAX_VALUE - 1 ? Integer.MAX_VALUE : Math.toIntExact(benchPoints));
        Save save = new Save(benchPoints);

        benchmarks[0] = new AESEncryption(benchPoints, data.getString(), new Data(benchPoints > Integer.MAX_VALUE - 1 ? Integer.MAX_VALUE : Math.toIntExact(benchPoints)).getString());
        benchmarks[1] = new Compression(benchPoints, data.getString());
        benchmarks[2] = new Decompression(benchPoints);
        benchmarks[3] = new MD5Hashing(benchPoints, data.getString());
        benchmarks[4] = new SHA256Hashing(benchPoints, data.getString());
        benchmarks[5] = new SHA512Hashing(benchPoints, data.getString());
        benchmarks[6] = new HeapSort(benchPoints, data.getNewArray());
        benchmarks[7] = new QuickSort(benchPoints, data.getNewArray());

        System.out.println("Benchmarking..." + System.lineSeparator());

        for (Benchmark benchmark : benchmarks) {
            testCounter++;
            System.out.println("Running benchmark " + testCounter + "/" + benchmarks.length + "...");
            for (int avgRun = 0; avgRun < 5; avgRun++) {
                currentScore += (benchmark.runTest() / 1000.0);
            }
            currentScore /= 5;
            benchmark.setScore(currentScore);
            currentScore = 0;
            finalScore += Score.getFromScores(benchmark.getName());
        }

        finalScore /= benchmarks.length;

        Score.addToScores("Final Score", finalScore);

        System.out.println(System.lineSeparator() + "Saving...");

        try {
            save.saveScore();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

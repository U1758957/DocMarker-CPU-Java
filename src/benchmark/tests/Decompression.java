package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class Decompression implements Benchmark {

    private static Score score = new Score();
    private static Timer timer = new Timer();

    public String getName() {
        return "Decompression";
    }

    @Override
    public void runTest() {

    }

    @Override
    public void setScore(int score) {

    }
}

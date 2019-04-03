package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

public class AESEncryption implements Benchmark {

    private long benchPoints;

    public AESEncryption(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    @Override
    public String getName() {
        return "AES Encryption";
    }

    @Override
    public long runTest() {
        Timer.startTiming();
        return (long) (benchPoints / Timer.endTiming());
    }

    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}

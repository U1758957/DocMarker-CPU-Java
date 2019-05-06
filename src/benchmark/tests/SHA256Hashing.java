package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hashing implements Benchmark {

    private long benchPoints;
    private String stringToHash;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     * @param stringToHash the string to hash
     */
    public SHA256Hashing(long benchPoints, String stringToHash) {
        this.benchPoints = benchPoints;
        this.stringToHash = stringToHash;
    }

    /**
     * Get the name of this test
     * @return the name of the test
     */
    @Override
    public String getName() {
        return "SHA-256 Hashing";
    }

    /**
     * Hash a string
     * @throws NoSuchAlgorithmException if the hashing algorithm doesn't exist
     */
    private void hashString() throws NoSuchAlgorithmException {

        StringBuilder hashHex;
        hashHex = new StringBuilder();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = digest.digest(stringToHash.getBytes(StandardCharsets.UTF_8));

        for (byte x : bytes) hashHex.append(String.format("%1$02X", x));
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        Timer.startTiming();
        try {
            hashString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (long) (benchPoints / Timer.endTiming());
    }

    /**
     * Store the score in the Score buffer class
     * @param score the score to set
     */
    @Override
    public void setScore(double score) {
        Score.addToScores(getName(), score);
    }
}

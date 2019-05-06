package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

public class Compression implements Benchmark {

    private long benchPoints;
    private String stringToCompress;
    private byte[] compressed;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     */
    public Compression(long benchPoints, String stringToCompress) {
        this.benchPoints = benchPoints;
        this.stringToCompress = stringToCompress;
    }

    /**
     * Get the name of this test
     * @return the name of the test
     */
    @Override
    public String getName() {
        return "Compression";
    }

    /**
     * Compress a string and save the result
     *
     * @throws IOException if the outputStream is null
     */
    private void compress() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        gzipOutputStream.write(stringToCompress.getBytes(StandardCharsets.UTF_8));
        gzipOutputStream.flush();
        gzipOutputStream.close();
        setCompressed(outputStream.toByteArray());
    }

    /**
     * Get the compressed string
     *
     * @return the compressed byte array
     */
    byte[] getCompressed() {
        return compressed;
    }

    /**
     * Set the compressed output for use with the decompressor
     *
     * @param compressed the compressed byte array
     */
    private void setCompressed(byte[] compressed) {
        this.compressed = compressed;
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        Timer.startTiming();
        try {
            compress();
        } catch (IOException e) {
            e.printStackTrace();
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

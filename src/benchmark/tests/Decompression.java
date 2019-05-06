package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class Decompression implements Benchmark {

    private long benchPoints;
    private byte[] dataToDecompress;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     */
    public Decompression(long benchPoints) {
        this.benchPoints = benchPoints;
    }

    /**
     * Get the name of this test
     * @return the name of the test
     */
    @Override
    public String getName() {
        return "Decompression";
    }

    private void decompress() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(dataToDecompress);
        GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(currentLine);
        }
        bufferedReader.close();
        gzipInputStream.close();
        inputStream.close();
    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        dataToDecompress = Compression.getCompressed();
        Timer.startTiming();
        try {
            decompress();
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

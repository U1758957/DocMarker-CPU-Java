package benchmark;

public interface Benchmark {

    long runTest();

    void setScore(long score);

    String getName();

}

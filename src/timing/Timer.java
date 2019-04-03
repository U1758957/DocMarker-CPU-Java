package timing;

public class Timer {

    private static double startTime;

    public static void startTiming() {
        startTime = System.nanoTime();
    }

    public static double endTiming() {
        return (System.nanoTime() - startTime) / 1_000_000d;
    }

}

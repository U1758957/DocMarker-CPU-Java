package timing;

public class Timer {

    private static double startTime;

    /**
     * Start the timer
     */
    public static void startTiming() {
        startTime = System.nanoTime();
    }

    /**
     * End the timer, and convert it to seconds
     *
     * @return the time elapsed in seconds
     */
    public static double endTiming() {
        return (System.nanoTime() - startTime) / 1_000_000_000d;
    }

}

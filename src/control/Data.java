package control;

import java.util.concurrent.ThreadLocalRandom;

class Data {

    private int[] data;
    private static final String characters = "QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm0123456789";
    private String string;

    /**
     * Generate a worst-case array
     *
     * @param size the size of the array
     */
    Data(int size) {
        data = new int[size];
        StringBuilder string = new StringBuilder();
        for (int x = 0; x < size; x++) {
            data[x] = size - x - 1;
            for (int y = 0; y < 100; y++) {
                string.append(characters.charAt(ThreadLocalRandom.current().nextInt(characters.length())));
            }
        }
        this.string = string.toString();
    }

    /**
     * Get a new instance of the array
     * @return a clone of the array
     */
    int[] getNewArray() {
        return data.clone();
    }

    String getString() {
        return string;
    }

}

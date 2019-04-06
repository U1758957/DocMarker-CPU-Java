package control;

class Data {

    private int[] data;

    /**
     * Generate a worst-case array
     *
     * @param size the size of the array
     */
    Data(int size) {
        data = new int[size];
        for (int x = 0; x < size; x++) {
            data[x] = size - x - 1;
        }
    }

    /**
     * Get a new instance of the array
     * @return a clone of the array
     */
    int[] getNewArray() {
        return data.clone();
    }
}

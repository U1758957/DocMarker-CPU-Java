package control;

class Data {

    private int[] data;

    Data(int size) {
        data = new int[size];
        for (int x = 0; x < size; x++) {
            data[x] = size - x - 1;
        }
    }

    int[] getNewArray() {
        return data.clone();
    }
}

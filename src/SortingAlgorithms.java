public class SortingAlgorithms {

    // Insertion Sort
    public static void insertionSort(String[] array, int delay, GameTable gameTable) {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            gameTable.printTable();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Bubble Sort
    public static void bubbleSort(String[] array, int delay, GameTable gameTable) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    gameTable.printTable();
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(String[] array, int delay, GameTable gameTable) {
        if (array == null || array.length < 2) return;
        mergeSortRecursive(array, 0, array.length - 1, delay, gameTable);
    }

    private static void mergeSortRecursive(String[] array, int left, int right, int delay, GameTable gameTable) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSortRecursive(array, left, mid, delay, gameTable);
        mergeSortRecursive(array, mid + 1, right, delay, gameTable);
        merge(array, left, mid, right, delay, gameTable);
    }

    private static void merge(String[] array, int left, int mid, int right, int delay, GameTable gameTable) {
        String[] temp = new String[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (array[i].compareTo(array[j]) <= 0) ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, left, temp.length);
        gameTable.printTable();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
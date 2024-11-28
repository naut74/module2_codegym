package InsertionSort;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentMin = list[i];
            int position = i;
            while (position > 0 && currentMin < list[position - 1]) {
                list[position] = list[position - 1];
                position--;
            }
            list[position] = currentMin;
        }
    }

    public static void main(String[] args) {
        int[] list = {1,2,34,456,23,5,134,2,4,34};
        insertionSort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}

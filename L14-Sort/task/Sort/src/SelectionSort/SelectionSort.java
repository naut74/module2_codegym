package SelectionSort;

public class SelectionSort {
    static double[] list = {1, 3, 12, 3, 9.3, 5.6, 8, 9, 7, 4};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMinIndex = j;
                    currentMin = list[j];
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (double i : list) {
            System.out.print(i + " ");
        }
    }
}

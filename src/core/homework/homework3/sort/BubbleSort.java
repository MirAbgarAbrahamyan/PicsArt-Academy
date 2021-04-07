package core.homework.homework3.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 5, -9, 2, -19, 8, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}

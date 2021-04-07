package picsartacademy.homework.homework2.task5;

public class Test {
    public static void main(String[] args) {
        float[] arr = {12.3F, 123F, 9,9778F, 3.14F, 0.577215F};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 24.12 && arr[i] <= 467.23)
                System.out.print(arr[i] + " ");
        }
    }
}

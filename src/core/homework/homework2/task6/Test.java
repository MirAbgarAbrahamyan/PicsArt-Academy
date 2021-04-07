package picsartacademy.homework.homework2.task6;

public class Test {
    public static void main(String[] args) {
        int count = 0;
        int[] arr = {1, 5, 8, 10, 2, 4, 3, 5, 6, 8, 8};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                count++;
        }
        System.out.println(count);
    }
}

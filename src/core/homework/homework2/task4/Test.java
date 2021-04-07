package picsartacademy.homework.homework2.task4;

public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 15};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0)
                System.out.print(arr[i] + " ");
        }
    }
}

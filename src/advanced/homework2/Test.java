package advanced.homework2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    static boolean isOneDigit(long n) {
        if (n == 0)
            return true;
        return (int) Math.floor(Math.log10(n) + 1) == 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter minutes:");
        long minutes = scan.nextLong();
        System.out.println("Enter seconds (if seconds >= 60 then it will be added to minutes):");
        long seconds = scan.nextLong();
        if (minutes < 0 || seconds < 0) {
            throw new RuntimeException("Minutes or seconds cannot be negative!");
        }
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        while (minutes != 0 || seconds != 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (seconds == 0) {
                minutes--;
                seconds = 60;
            }
            seconds--;
            System.out.println((isOneDigit(minutes) ? "0" + minutes : minutes) +
                    (isOneDigit(seconds) ? "::0" : "::") + seconds);
        }
    }
}

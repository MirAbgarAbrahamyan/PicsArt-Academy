package core.midtermexam1;

import java.util.Scanner;

public class TaxiService {
    Scanner scan = new Scanner(System.in);
    public Taxi createTaxi() {
        System.out.println("Enter the model:");
        String model = scan.next();
        System.out.println("Enter the country:");
        String country = scan.next();
        System.out.println("Enter the year:");
        int year = scan.nextInt();
        System.out.println("Enter the milage:");
        int milage = scan.nextInt();
        System.out.println("If the car is sport enter 'y' otherwise 'n'" +
                " without quotation marks:");
        char sport = scan.next().charAt(0);
        System.out.println("Enter the weight:");
        int weight = scan.nextInt();
        System.out.println("Enter the top speed:");
        int topSpeed = scan.nextInt();
        System.out.println("Enter the number of seats:");
        int seats = scan.nextInt();
        System.out.println("Enter the cost:");
        double cost = scan.nextDouble();
        return new Taxi(model, country, year, milage, sport == 'y' ? true : false,
                weight, topSpeed, seats, cost);
    }

    public void printTaxiInfo(Taxi taxi) {
        System.out.println("Model: " + taxi.getModel() + "\n" +
                "Country: " + taxi.getCountry() + "\n" +
                "Year: " + taxi.getYear() + "\n" +
                "Milage: " + taxi.getMilage() + "\n" +
                (taxi.isSport() == true ? "Sport Car" : "Not Sport Car") + "\n" +
                "Weight: " + taxi.getWeight() + "kg\n" +
                "Top Speed: " + taxi.getTopSpeed() + " km/h\n" +
                "Number of Seats: " + taxi.getSeats() + "\n" +
                "Cost: " + taxi.getCost() + "$\n\n");
    }

    // task 1
    public void printTopSpeedCostOrModelCountry(Taxi taxi) {
        if (taxi.isSport()) {
            System.out.println(taxi.getCost() + "\n" + taxi.getTopSpeed());
        }
        else {
            System.out.println(taxi.getModel() + "\n" + taxi.getCountry());
        }
        System.out.println("\n\n");
    }

    // task 2
    public Taxi newerTaxiFromTwo(Taxi t1, Taxi t2) {
        if (t2.getYear() > t1.getYear())
            return t2;
        return t1;
    }

    // task 3
    public void smallerSteatsFromThree(Taxi t1, Taxi t2, Taxi t3) {
        if (t2.getSeats() <= t3.getSeats()) {
            if (t2.getSeats() < t1.getSeats()) {
                System.out.println(t2.getCountry());
                return;
            }
        }
        else {
            if (t3.getSeats() < t1.getSeats()) {
                System.out.println(t3.getCountry());
                return;
            }
        }
        System.out.println(t1.getCountry());
    }

    // task 4
    public void printSportTaxis(Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (taxi.isSport())
                printTaxiInfo(taxi);
        }
    }

    // task 5
    public void printSportMoreThan50000(Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (taxi.isSport() && taxi.getMilage() > 50000)
                printTaxiInfo(taxi);
        }
    }

    // task 6
    public Taxi printMinimalWeightTaxi(Taxi[] taxis) {
        Taxi min = taxis[0];
        for (Taxi taxi : taxis) {
            if (taxi.getWeight() <= min.getWeight()) {
                min = taxi;
            }
        }
        return min;
    }

    // task 7
    public Taxi minCostSportTaxi(Taxi[] taxis) {
        Taxi min = null;
        int i = 0;
        for (; i < taxis.length; i++) {
            if (taxis[i].isSport()) {
                min = taxis[i++];
                break;
            }
        }
        for (; i < taxis.length; i++) {
            if (taxis[i].isSport() && taxis[i].getCost() < min.getCost())
                min = taxis[i];
        }
        return min;
    }

    // task 8
    public void sortTaxisInAscendingYearAndPrint(Taxi[] taxis) {
        for (int i = 0; i < taxis.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < taxis.length - i - 1; j++) {
                if (taxis[j].getYear() > taxis[j + 1].getYear()) {
                    Taxi temp = taxis[j];
                    taxis[j] = taxis[j + 1];
                    taxis[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false)
                break;
        }
        for (Taxi taxi : taxis) {
            printTaxiInfo(taxi);
        }
    }
}

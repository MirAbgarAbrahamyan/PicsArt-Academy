package core.midtermexam1;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        Taxi taxi = taxiService.createTaxi();
        Taxi taxi2 = taxiService.createTaxi();
        Taxi taxi3 = taxiService.createTaxi();
        Taxi[] taxis = {taxi, taxi2, taxi3};

        Taxi testTaxiForReturnValue;

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\t\tMENU\n" +
                    "Enter 1 for task 1\n" +
                    "Enter 2 for task 2\n" +
                    "Enter 3 for task 3\n" +
                    "Enter 4 for task 4\n" +
                    "Enter 5 for task 5\n" +
                    "Enter 6 for task 6\n" +
                    "Enter 7 for task 7\n" +
                    "Enter 8 for task 8\n" +
                    "Enter 0 to exit");
            int button = scan.nextInt();
            switch (button) {
                case 1:
                    taxiService.printTopSpeedCostOrModelCountry(taxi);
                    break;
                case 2:
                    testTaxiForReturnValue = taxiService.newerTaxiFromTwo(taxi, taxi2);
                    taxiService.printTaxiInfo(testTaxiForReturnValue);
                    break;
                case 3:
                    taxiService.smallerSteatsFromThree(taxi, taxi2, taxi3);
                    break;
                case 4:
                    taxiService.printSportTaxis(taxis);
                    break;
                case 5:
                    taxiService.printSportMoreThan50000(taxis);
                    break;
                case 6:
                    testTaxiForReturnValue = taxiService.printMinimalWeightTaxi(taxis);
                    taxiService.printTaxiInfo(testTaxiForReturnValue);
                    break;
                case 7:
                    testTaxiForReturnValue = taxiService.minCostSportTaxi(taxis);
                    taxiService.printTaxiInfo(testTaxiForReturnValue);
                    break;
                case 8:
                    taxiService.sortTaxisInAscendingYearAndPrint(taxis);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No such button exists try again");
            }
        }
    }
}

// some random test cases XD
/*
Mercedes
Germany
2019
70000
y
1001
220
1
4721.125
BMW
AGermany
2009
100000
n
10
198
2
3000.125
Audi
BGermany
2017
10000
y
3000
210
0
4000.125
 */
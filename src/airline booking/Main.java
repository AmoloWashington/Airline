import java.util.Scanner;

public class AirlineReservationSystem {
    private static boolean[] seats = new boolean[11]; // Index 0 is unused
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please type 1 for First Class or 2 for Economy:");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                int seatNumber = assignSeat(true);
                if (seatNumber != -1) {
                    printBoardingPass(seatNumber, "First Class");
                } else {
                    System.out.println("First Class is full. Would you like to be placed in Economy? (Y/N)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("Y")) {
                        seatNumber = assignSeat(false);
                        if (seatNumber != -1) {
                            printBoardingPass(seatNumber, "Economy");
                        } else {
                            System.out.println("Economy is also full. Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else if (choice == 2) {
                int seatNumber = assignSeat(false);
                if (seatNumber != -1) {
                    printBoardingPass(seatNumber, "Economy");
                } else {
                    System.out.println("Economy is full. Would you like to be placed in First Class? (Y/N)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("Y")) {
                        seatNumber = assignSeat(true);
                        if (seatNumber != -1) {
                            printBoardingPass(seatNumber, "First Class");
                        } else {
                            System.out.println("First Class is also full. Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
    }
    
    private static int assignSeat(boolean isFirstClass) {
        int start = isFirstClass ? 1 : 6;
        int end = isFirstClass ? 5 : 10;
        
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i;
            }
        }
        
        return -1; // No available seat
    }
    
    private static void printBoardingPass(int seatNumber, String section) {
        System.out.println("\nBoarding Pass");
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Section: " + section);
    }
}

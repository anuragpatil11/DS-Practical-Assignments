import java.util.Scanner;

public class ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int numberOfProcesses = sc.nextInt();
        boolean[] active = new boolean[numberOfProcesses];

        for (int i = 0; i < numberOfProcesses; i++) {
            active[i] = true;
        }

        int coordinator = numberOfProcesses - 1; // Initially, the highest ID is coordinator
        int choice;

        do {
            System.out.println("\n--- Ring Election Menu ---");
            System.out.println("1. Select a Coordinator");
            System.out.println("2. Crash a Process");
            System.out.println("3. Start Recovery (Ring Election)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new coordinator (0 to " + (numberOfProcesses - 1) + "): ");
                    int newCoord = sc.nextInt();
                    if (newCoord >= 0 && newCoord < numberOfProcesses && active[newCoord]) {
                        coordinator = newCoord;
                        System.out.println("New coordinator is: P" + coordinator);
                    } else {
                        System.out.println("Invalid or inactive process.");
                    }
                    break;

                case 2:
                    System.out.print("Select a process to crash (0 to " + (numberOfProcesses - 1) + "): ");
                    int crashProcess = sc.nextInt();
                    if (crashProcess >= 0 && crashProcess < numberOfProcesses && active[crashProcess]) {
                        active[crashProcess] = false;
                        System.out.println("Process P" + crashProcess + " is crashed.");
                        if (crashProcess == coordinator) {
                            System.out.println("Coordinator has crashed!");
                            coordinator = -1; // Reset coordinator
                        }
                    } else {
                        System.out.println("Invalid or already crashed process.");
                    }
                    break;

                case 3:
                    System.out.print("Enter process ID to initiate election (0 to " + (numberOfProcesses - 1) + "): ");
                    int processToElection = sc.nextInt();
                    if (!active[processToElection]) {
                        System.out.println("This process is not active and cannot start election.");
                        break;
                    }

                    int[] candidates = new int[numberOfProcesses];
                    int count = 0;

                    for (int i = 0; i < numberOfProcesses; i++) {
                        int current = (processToElection + i) % numberOfProcesses;
                        if (active[current]) {
                            System.out.println("P" + current + " passes election message.");
                            candidates[count++] = current;
                        }
                    }

                    // Find the highest process ID among active ones
                    int newCoordinator = -1;
                    for (int i = 0; i < count; i++) {
                        if (candidates[i] > newCoordinator) {
                            newCoordinator = candidates[i];
                        }
                    }

                    if (newCoordinator != -1) {
                        coordinator = newCoordinator;
                        System.out.println("New coordinator is: P" + coordinator);
                    } else {
                        System.out.println("No active processes found to elect a coordinator.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        } while (choice != 4);
    }
}

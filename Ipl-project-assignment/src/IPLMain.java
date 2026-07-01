// IPLMain.java
// This is the MAIN class - the entry point of our program.
// It just shows a menu, takes user choice, and CALLS functions
// from PlayerService.java using a switch-case (as your teacher wants).

import java.util.Scanner;

public class IPLMain {

    public static void main(String[] args) {

        // Scanner reads input typed by the user in console
        Scanner sc = new Scanner(System.in);

        // We create ONE PlayerService object - this object does all the real work
        PlayerService service = new PlayerService();

        int choice; // stores the menu option chosen by user

        // do-while loop so the menu keeps showing until user chooses Exit
        do {
            // ---- Print the menu ----
            System.out.println("\n===== IPL PLAYER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Player");
            System.out.println("2. Search Player by Name");
            System.out.println("3. Search Team (show all players of a team)");
            System.out.println("4. Display All Players");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();   // read the number user typed
            sc.nextLine();           // consume the leftover newline character

            // ---- switch-case: decides which function to call based on choice ----
            switch (choice) {

                case 1:
                    // ----- ADD PLAYER -----
                    System.out.print("Enter Player Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Jersey Number: ");
                    int jersey = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Team Name: ");
                    String team = sc.nextLine();

                    System.out.print("Enter Bid Amount: ");
                    double bid = sc.nextDouble();
                    sc.nextLine();

                    // create a new Player object with the entered details
                    Player newPlayer = new Player(name, jersey, team, bid);

                    // call PlayerService to actually save it to the file
                    service.addPlayer(newPlayer);
                    break;

                case 2:
                    // ----- SEARCH PLAYER BY NAME -----
                    System.out.print("Enter Player Name to search: ");
                    String searchName = sc.nextLine();
                    service.searchPlayerByName(searchName);
                    break;

                case 3:
                    // ----- SEARCH ALL PLAYERS OF A TEAM -----
                    System.out.print("Enter IPL Team Name to search: ");
                    String searchTeam = sc.nextLine();
                    service.searchTeamPlayers(searchTeam);
                    break;

                case 4:
                    // ----- DISPLAY ALL PLAYERS -----
                    service.displayAllPlayers();
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    // runs if user enters a number that's not 1-5
                    System.out.println("Invalid choice! Please enter between 1 and 5.");
            }

        } while (choice != 5); // keep looping until user picks Exit (5)

        sc.close(); // always close the Scanner when done
    }
}

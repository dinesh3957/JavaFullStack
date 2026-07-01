// PlayerService.java
// This class contains the actual LOGIC: searching for a player, searching a whole team,
// and adding a new player. It uses FileManager underneath to read/write the CSV.
// We keep "logic" separate from "menu/input" (that part is in IPLMain.java).

import java.util.List;

public class PlayerService {

    // We create ONE FileManager object here and reuse it for every operation
    private FileManager fileManager = new FileManager();

    // ---- addPlayer(): adds a new player to the CSV file ----
    public void addPlayer(Player newPlayer) {
        // We simply append the new player as a new line in the CSV file (fast, optimized)
        fileManager.appendPlayer(newPlayer);
        System.out.println("Player added successfully!");

        // If later you want to print the added player's details, use this line:
        // System.out.println("Added -> " + newPlayer);
    }

    // ---- searchPlayerByName(): searches one player by name and prints details ----
    public void searchPlayerByName(String name) {

        // Read all players currently stored in the CSV
        List<Player> allPlayers = fileManager.readAllPlayers();

        boolean found = false; // flag to track whether we found the player

        // loop through every player and compare names (ignore upper/lower case)
        for (Player p : allPlayers) {
            if (p.getPlayerName().equalsIgnoreCase(name)) {
                System.out.println("Player Found:");
                System.out.println(p); // uses toString() of Player class
                // line to print details is the above System.out.println(p);
                found = true;
                break; // stop searching once found (player names are unique)
            }
        }

        if (!found) {
            System.out.println("No player found with name: " + name);
        }
    }

    // ---- searchTeamPlayers(): searches by IPL TEAM name, shows ALL players of that team ----
    public void searchTeamPlayers(String teamName) {

        List<Player> allPlayers = fileManager.readAllPlayers();

        boolean found = false;

        System.out.println("Players in team " + teamName + ":");

        // loop through every player, print the ones matching the given team name
        for (Player p : allPlayers) {
            if (p.getTeamName().equalsIgnoreCase(teamName)) {
                System.out.println(p); // prints full player detail line
                found = true;
            }
        }

        if (!found) {
            System.out.println("No players found for team: " + teamName);
        }
    }

    // ---- displayAllPlayers(): utility function to show every player (handy for testing) ----
    public void displayAllPlayers() {
        List<Player> allPlayers = fileManager.readAllPlayers();

        if (allPlayers.isEmpty()) {
            System.out.println("No player records found.");
            return;
        }

        for (Player p : allPlayers) {
            System.out.println(p);
        }
    }
}

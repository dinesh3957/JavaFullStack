// FileManager.java
// This class handles ALL the reading and writing to the CSV file.
// We use Java Stream I/O classes: FileWriter, BufferedWriter (to write)
// and FileReader, BufferedReader (to read).
// Keeping file-handling code separate from logic is good practice.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // Path of our CSV file. Keep it in the same "src" folder for simplicity.
    private static final String FILE_NAME = "src/players.csv";

    // Header line that should always be the first line of the CSV
    private static final String HEADER = "PlayerName,JerseyNumber,TeamName,BidAmount";

    // ---- readAllPlayers(): reads every line of the CSV and converts to Player objects ----
    public List<Player> readAllPlayers() {

        // ArrayList to collect all players we read from file
        List<Player> playerList = new ArrayList<>();

        // try-with-resources automatically closes the stream after use (no need for finally block)
        // BufferedReader wraps FileReader to read text FASTER (line by line) -> this is the "stream IO"
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;            // holds one line of text at a time
            boolean isFirstLine = true; // used to skip the header row

            // readLine() returns null when end of file is reached
            while ((line = reader.readLine()) != null) {

                // Skip the header line ("PlayerName,JerseyNumber,TeamName,BidAmount")
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // skip any accidental empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // CSV columns are separated by commas, so split the line by ","
                String[] parts = line.split(",");

                // parts[0]=name, parts[1]=jersey, parts[2]=team, parts[3]=bid
                String name = parts[0].trim();
                int jersey = Integer.parseInt(parts[1].trim());
                String team = parts[2].trim();
                double bid = Double.parseDouble(parts[3].trim());

                // create a Player object and add it to our list
                playerList.add(new Player(name, jersey, team, bid));
            }

        } catch (IOException e) {
            // If file does not exist yet, just return an empty list
            System.out.println("No existing data file found. Starting fresh.");
        }

        return playerList;
    }

    // ---- writeAllPlayers(): overwrites the whole CSV file with the given list ----
    // Used after adding a new player, so the file always stays "optimized" (no duplicates/blank lines)
    public void writeAllPlayers(List<Player> playerList) {

        // BufferedWriter wraps FileWriter for FAST writing.
        // "false" in FileWriter means OVERWRITE the file (not append) so old/duplicate data is removed
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {

            // first write the header line
            writer.write(HEADER);
            writer.newLine();

            // then write every player as one CSV line
            for (Player p : playerList) {
                writer.write(p.toCsvLine());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    // ---- appendPlayer(): adds just ONE new player line to the end of file (faster than rewriting all) ----
    public void appendPlayer(Player player) {

        // "true" in FileWriter means APPEND mode (adds to end, doesn't erase old data)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(player.toCsvLine());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error while adding player: " + e.getMessage());
        }
    }
}

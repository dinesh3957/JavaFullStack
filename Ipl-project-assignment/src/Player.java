// Player.java
// This class is just a "blueprint" of one Player.
// Every player has 4 things: name, jersey number, team name, bid amount.
// We use this class so that instead of handling 4 separate variables everywhere,
// we handle ONE Player object everywhere. This is called "encapsulation".

public class Player {

    // ---- Fields (these store the data of ONE player) ----
    private String playerName;     // player's name
    private int jerseyNumber;      // player's jersey number
    private String teamName;       // IPL team name (RCB, MI, CSK, etc.)
    private double bidAmount;      // auction bid amount

    // ---- Constructor: used when we create a new Player object ----
    // Example: new Player("Virat Kohli", 18, "RCB", 1500)
    public Player(String playerName, int jerseyNumber, String teamName, double bidAmount) {
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.teamName = teamName;
        this.bidAmount = bidAmount;
    }

    // ---- Getters: used to READ the values from outside this class ----
    public String getPlayerName() {
        return playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    // ---- Setters: used to CHANGE the values from outside this class ----
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    // ---- toCsvLine(): converts this Player object into ONE line of CSV text ----
    // Example output: "Virat Kohli,18,RCB,1500.0"
    public String toCsvLine() {
        return playerName + "," + jerseyNumber + "," + teamName + "," + bidAmount;
    }

    // ---- toString(): decides how a Player looks when we print it ----
    // This is the line you can adjust to change how player details are displayed.
    // (Edit below if you want a different print style)
    @Override
    public String toString() {
        return "Player Name : " + playerName +
                " | Jersey No : " + jerseyNumber +
                " | Team : " + teamName +
                " | Bid Amount : " + bidAmount + " Lakhs";
        // System.out.println("Customize this print format here if your teacher wants something different");
    }
}

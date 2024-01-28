package arrayList;

public class Game {

    public static void main(String[] args) {
        // Test the GameEntry class
        GameEntry entry1 = new GameEntry("Player1", 100);
        GameEntry entry2 = new GameEntry("Player2", 150);

        System.out.println("GameEntry 1: " + entry1.toString());
        System.out.println("GameEntry 2: " + entry2.toString());

        // Test the ScoreBoard class
        ScoreBoard scoreBoard = new ScoreBoard(5);

        // Add entries to the scoreboard
        scoreBoard.add(entry1);
        scoreBoard.add(entry2);

        // Print the scoreboard
        System.out.println("Initial Scoreboard:");
        printScoreBoard(scoreBoard);

        // Add more entries
        GameEntry entry3 = new GameEntry("Player3", 120);
        GameEntry entry4 = new GameEntry("Player4", 90);
       
        scoreBoard.add(entry3);
        scoreBoard.add(entry4);

        // Print the updated scoreboard
        System.out.println("\nUpdated Scoreboard:");
        printScoreBoard(scoreBoard);

        // Remove an entry and print the final scoreboard
        scoreBoard.remove(2);
        System.out.println("\nFinal Scoreboard:");
        printScoreBoard(scoreBoard);
    }

    private static void printScoreBoard(ScoreBoard scoreBoard) {
        for (int i = 0; i < scoreBoard.getNumEntries(); i++) {
            System.out.println("Rank " + (i + 1) + ": " + scoreBoard.getBoard()[i].toString());
        }
    }
}

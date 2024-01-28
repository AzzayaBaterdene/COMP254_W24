package arrayList;

public class ScoreBoard {
    private int numEntries = 0;
    private GameEntry[] board;  //arr of game entries(names and scores)

    // Construction
    public ScoreBoard(int capacity){
        board = new GameEntry[capacity];
    }

    public int getNumEntries() {
        return numEntries;
    }
    
    public GameEntry[] getBoard() {
        return board;
    }

    public void add(GameEntry e){
        int newScore = e.getScore();

        //is new entry e is really high score?
        if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
            if(numEntries < board.length)
                numEntries++;

            // shift any lower scores rightward to make room for the new entry
            int j = numEntries-1;
            while (j>0 && board[j-1].getScore() < newScore) {
                board[j] = board[j-1];
                j--;
            }
            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i<0 || i>= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        
        //Save the obj to be removed
        GameEntry temp = board[i];
        for(int j=i; j<numEntries-1; j++)
            board[j] = board[j+1];
        board[numEntries-1] = null; //null out the old last score   
        numEntries--;

        return temp;  //return the removed obj
    }
}




package arrayList;
//Array practice

public class GameEntry {
    private String name;
    private int score;

    // Constructor
    public GameEntry (String n, int s){
        this.name = n;
        this.score = s;
    }
    
    // returns name field
    public String getName(){ return name; }

    // returns score field
    public int getScore(){ return score; }

    public String toString(){
        return "Name: " + name + " Score: " + score;
    }
    

}
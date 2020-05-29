package Battleships;

public class Player extends Board{
    private String name;
    private int points;

    public Player(String name){
        super();
        this.name = name;
        this.points = 0;
    }

    public String getName(){
        return this.name;
    }

    public void setPoints(){
        this.points++;
    }

    public int getPoints(){
        return this.points;
    }

    public String toString(){
        String result = "";
        result += "Player: " + this.name + " Points: " + this.points + "\n";
        result += super.toString();
        return result;
    }
}
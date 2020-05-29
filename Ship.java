package Battleships;

public class Ship {
    private String name;
    private int size;
    private String alignment;
    private int hitNumber;

    public Ship(String name, int size){
        this.name = name;
        this.size = size;

    }

    public void setAlignment(String alignment){
        this.alignment = alignment;
    }

    public String getAlignment(){
        return this.alignment;
    }

    public String getShipAbbreviation(){
        String result = "";
        int count = 0;
        for(int i = 0; i < this.name.length(); i++){
            char c = this.name.toUpperCase().charAt(i);
            if(!"AEIOU".contains(String.valueOf(c)) && count != 4){
                result += c;
                count++;
            }
        }
        return result;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }

    public void setHit(){
        this.hitNumber++;
    }

    public int getHit(){
        return this.hitNumber;
    }
}
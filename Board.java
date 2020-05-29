package Battleships;

import java.util.ArrayList;

public class Board {
    String [][] board;
    ArrayList<Ship> ships = new ArrayList<>();
    

    public Board(){
        board = new String[10][10];
        this.ships.add(new Ship("Carrier", 5));
        this.ships.add(new Ship("Battleship", 4));
        this.ships.add(new Ship("Destroyer", 3));
        this.ships.add(new Ship("Submarine", 3));
        this.ships.add(new Ship("Patrol Boat", 2));
    }

    public int convertFromCharToInt(char columnChar){
        int column = -1;
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J"};
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i].charAt(0) == columnChar || alphabet[i].toLowerCase().charAt(0) == columnChar){
                column = i;
            }
        }
        return column;
    }

    public boolean ShipPlacing(Ship s, int row, int column, String alignment){
        if(this.board[row][column] == null){
            if(alignment.equalsIgnoreCase("vertical") || checkIfSimilarToV(alignment)){
                verticalPlacing(s, row, column);
                return true;
            }else if(alignment.equalsIgnoreCase("horizontal") || checkIfSimilarToH(alignment)){
                horizontalPlacing(s, row, column);
                return true;
            }
        }
        return false;
    }

    public boolean checkIfSimilarToV(String alignment){
        String test = "vertical";
        int similarChar = 0;
        for(int i = 0; i < alignment.length(); i++){
            if(test.charAt(0) == alignment.charAt(0)){
                similarChar++;
            }
        }

        if(similarChar > 2){
            return true;
        }

        return false;
    }

    public boolean checkIfSimilarToH(String alignment){
        String test = "horizontal";
        int similarChar = 0;
        for(int i = 0; i < alignment.length(); i++){
            if(test.charAt(0) == alignment.charAt(0)){
                similarChar++;
            }
        }

        if(similarChar > 2){
            return true;
        }

        return false;
    }

    public void verticalPlacing(Ship s, int row, int column){
        int size = 0;
        if((row + s.getSize()) < this.board.length){
            // for(int i = row; i < this.board.length; i++){
            //     if(size != s.getSize()){
            //         this.board[row][column] = s.getShipAbbreviation();
            //         size++;
            //     }
            // }
            while(size != s.getSize()){
                this.board[row][column] = s.getShipAbbreviation();
                row++;
                size++;
            }
        }else{
            // for(int i = row; i > -1; i--){
            //     if(size != s.getSize()){
            //         this.board[row][column] = s.getShipAbbreviation();
            //         size++;
            //     }
            // }
            while(size != s.getSize()){
                this.board[row][column] = s.getShipAbbreviation();
                row--;
                size++;
            }
        }
    }

    public void horizontalPlacing(Ship s, int row, int column){
        int size = 0;
        if((column + s.getSize() < this.board[0].length)){
            while(size != s.getSize()){
                this.board[row][column] = s.getShipAbbreviation();
                column++;
                size++;
            }
        }else{
            while(size != s.getSize()){
                this.board[row][column] = s.getShipAbbreviation();
                column--;
                size++;
            }
        }
    }

    public String attack(int row, int column){
        String result = "";
        if(this.board[row][column] == null){
            result = "MANCATO!";
        }else{
            for(Ship s : this.ships){
                if(s.getShipAbbreviation().equalsIgnoreCase(this.board[row][column]) && !this.board[row][column].equalsIgnoreCase("XXXX")){
                    s.setHit();
                    this.board[row][column] = "XXXX";
                    if(s.getHit() == s.getSize()){
                        result = "COLPITO E AFFONDATO!";
                    }else{
                        result = "COLPITO!";
                    }
                }
            }
        }
        return result;
    }

    public String toString(){
        String result = "";

        for(int column = 0; column < this.board[0].length; column++){
            String[] alphabet = {"A","B","C","D","E","F","G","H","I","J"};
            if(column == 0){
                result += "\t";
            }
            result += alphabet[column] + "\t";
            
        }
        result += "\n";

        for(int row = 0; row < this.board.length; row++){
            if((row+1) < 10){
                result += (row+1) + "     |";
            }else{
                result += (row+1) + "    |";
            }
            for(int col = 0; col < this.board[row].length; col++){
                if(col != this.board[row].length-1){
                    result += this.board[row][col] + "    ";
                    /*if(this.board[row][col] == null){
                        result += "\u001B[34m\uD83C\uDF0A\u001B[0m";
                    }else{
                        result += this.board[row][col] + "    ";
                    }*/
                }else{
                    result += this.board[row][col];
                }
            }
            result += "|\n";
        }

        return result;
    }
}
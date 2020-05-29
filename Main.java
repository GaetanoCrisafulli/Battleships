package Battleships;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        //Board b = new Board();
        //System.out.println(b);
        Scanner scan = new Scanner(System.in);
        Player p1 = new Player("Giocatore 1");
        Player p2 = new Player("Giocatore 2");
        int numberOfShipsP1 = 0, numberOfShipsP2 = 0;
        int i = 0, j = 0;
        System.out.println("Ships placing: " + p1.getName() + "\n");
        System.out.println(p1);
        while (numberOfShipsP1 != 5) {
            int row = 0, column = 0;
            String alignment = "";
            char columnChar = ' ';
            System.out.println("Where do you want to place the " + p1.ships.get(i).getName() + "?");
            System.out.println("Insert the coordinates.");
            System.out.print("Row: ");
            row = scan.nextInt() - 1;
            scan.nextLine();
            System.out.print("column:");
            columnChar = scan.nextLine().charAt(0);
            column = p1.convertFromCharToInt(columnChar);
            System.out.print("Insert the alignment: ");
            alignment = scan.nextLine();
            p1.ships.get(i).setAlignment(alignment);
            if(p1.ShipPlacing(p1.ships.get(i), row, column, p1.ships.get(i).getAlignment()) == true){
                i++;
                numberOfShipsP1++;
                System.out.println(p1);
            }else{
                System.out.println("THIS COORDINATES ARE ALREADY OCCUPIED.");
            }
        }


        System.out.println("Ships placing: " + p2.getName() + "\n");
        System.out.println(p2);
        while (numberOfShipsP2 != 5) {
            int row = 0, column = 0;
            String alignment = "";
            char columnChar = ' ';
            System.out.println("Where do you want to place the " + p2.ships.get(j).getName() + "?");
            System.out.println("Insert the coordinates.");
            System.out.print("Row: ");
            row = scan.nextInt() - 1;
            scan.nextLine();
            System.out.print("column:");
            columnChar = scan.nextLine().charAt(0);
            column = p2.convertFromCharToInt(columnChar);
            System.out.print("Insert the alignment: ");
            alignment = scan.nextLine();
            p2.ships.get(j).setAlignment(alignment);
            if(p2.ShipPlacing(p2.ships.get(j), row, column, p2.ships.get(j).getAlignment()) == true){
                j++;
                numberOfShipsP2++;
                System.out.println(p2);
            }else{
                System.out.println("THIS COORDINATES ARE ALREADY OCCUPIED.");
            }
        }

        if(numberOfShipsP1 == 5 && numberOfShipsP2 == 5){
            System.out.println("ATTACK PHASE");
            while(p1.getPoints() != 2 || p2.getPoints() != 2){
                int row = 0, column = 0;
                char columnChar = ' ';
                String attack = "";
                System.out.println("PLAYER: " + p1.getName() + " IT'S YOUR TURN!\n");
                System.out.println("Where do you want to attack?");
                System.out.println("Insert the coordinates.");
                System.out.print("Row: ");
                row = scan.nextInt() - 1;
                scan.nextLine();
                System.out.print("column:");
                columnChar = scan.nextLine().charAt(0);
                column = p1.convertFromCharToInt(columnChar);
                attack = p2.attack(row, column);
                if(!attack.equalsIgnoreCase("mancato!")){
                    p1.setPoints();
                }
                System.out.println(attack + "\n");
                System.out.println(p1 + "\n\n");

                if(p1.getPoints() == 2){
                    System.out.println(p1.getName().toUpperCase() + " WINS");
                    break;
                }

                System.out.println("PLAYER: " + p2.getName() + " IT'S YOUR TURN!\n");
                System.out.println("Where do you want to attack?");
                System.out.println("Insert the coordinates.");
                System.out.print("Row: ");
                row = scan.nextInt() - 1;
                scan.nextLine();
                System.out.print("column:");
                columnChar = scan.nextLine().charAt(0);
                column = p2.convertFromCharToInt(columnChar);
                attack = p1.attack(row, column);
                if(!attack.equalsIgnoreCase("mancato!")){
                    p2.setPoints();
                }
                System.out.println(attack + "\n");
                System.out.println(p2 + "\n\n");

                if(p2.getPoints() == 2){
                    System.out.println(p2.getName().toUpperCase() + "WINS");
                    break;
                }
            }
        }

        
    }
}
/*
 * Jakob M Paulson-Palmer
 * The main class is responsible for creating the main java Frame the game will 
 * be played on.
 */
package Game;

import ML.Bot;
import ML.TournDirector;

public class main {

    static Cell[][] grid = new Cell[5][5];

    Life aLife = new Life(); //Make blank life
    //static Bot botty = new Bot(); // Give blank life to bot

    //Init life - early game
    //update life - mid game
    //count life - results of game
    public static void main(String[] args) {

        System.out.println("Program Start");
        
        //GAME setup
        new LifeFrame();

    }

    
//    private static void display() {
//        System.out.println("the grid...");
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(" " + grid[i][j].display());
//            }
//            System.out.println("");
//        }
//    }
//
//    private static void parse(Cell[] row, String input) {
//        System.out.println("input = " + input);
//        for (int i = 0; i < input.length(); i++) {
//            System.out.println("i = " + i);
//            row[i].setAlive(input.charAt(i) == '.');
//        }
//    }
//
//    private static void init() {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                grid[i][j] = new Cell();
//            }
//        }
//    }
}

package Game;

import java.awt.Graphics;
import ML.Bot;

/**
 * @author levenick Jan 19, 2017 2:44:19 PM
 */
public class Life {

    //Keep N : xN = x : 2x
    final static int N = 30; //board Y size
    final static int xN = 2 * N; //Board X size
    //final static int nTwo = 2*N;

    Cell[][] cells;

    //CONSTRUCTORS-------
    public Life() {
        cells = new Cell[N][xN];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < (2 * N); col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public Life(int n) {
        cells = new Cell[n][2 * n];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < (2 * N); col++) {
                cells[row][col] = new Cell();
            }
        }
    }
        //        cells[5][5].setAlive(true);
        //        cells[5][6].setAlive(true);
        //        cells[5][7].setAlive(true);
        //        cells[6][7].setAlive(true);
        //        cells[7][6].setAlive(true);
        //        cells[7][7].setAlive(true);

        //    Life(Bot benjerman) {
        //        benjerman.getDNA();
        //    }
        //-------------------
    public String toString() {
        String returnMe = "";

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < (xN); col++) {
                returnMe += cells[row][col].display();
            }
            returnMe += "\n";
        }

        return returnMe;
    }

    public String toStringBar(boolean disp) {
        String returnMe = "";

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < (xN); col++) {
                if (col == N && disp) {
                    returnMe += "|";
                }
                returnMe += cells[row][col].display();

            }
            returnMe += "\n";
        }

        return returnMe;
    }

    public String toStringCounts() {
        String returnMe = "";

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < xN; col++) {
                returnMe += cells[row][col].getNumNbrs();
            }
            returnMe += "\n";
        }

        return returnMe;
    }

    void step() {
        countNbrs();
        //System.out.println("toStringCounts() = \n" + toStringCounts());
        update();
    }

    private void countNbrs() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < xN; col++) { //Breaks when change to xN
                countNbrs(row, col);
            }
        }
    }

    void countNbrs(int row, int col) {
        int count = 0;                                  // count the nbrs of [row][col]
        for (int i = row - 1; i <= row + 1; i++) {

            for (int j = col - 1; j <= col + 1; j++) {

                if ((i != row || j != col) && cells[fix(i)][fixX(j)].isAlive()) {
                    count++;
                }

            }
        }
        cells[row][col].setNumNbrs(count);              // set the instance variable!!
    }

    private void update() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < xN; col++) {
                cells[row][col].update();
            }
        }
    }

    //DOSENT WORK FOR RIGHT SIDE
    private int fix(int n) {
        if (n == -1) {
            return N - 1;
        }
        if (n == N) {
            return 0;
        }
        return n;
    }

    private int fixX(int n) {
        if (n == -1) {
            return xN - 1;
        }
        if (n == xN) {
            return 0;
        }
        return n;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getN() {
        return N;
    }

    public int getXN() {
        return N * 2;
    }

    public void setCells(int i, int j) {
        cells[i][j].setAlive(true);
    }

    public void zeroCells() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < xN; j++) {
                cells[i][j].setAlive(false);
            }
        }
    }

}

package Game;

/**
 * @author levenick Jan 19, 2017 2:46:24 PM
 */
public class Cell {

    boolean alive;
    int numNbrs;

    private char ALIVE = 'O';
    private char DEAD = '-';
    int xCoord;
    int yCoord;

    public int getNumNbrs() {
        return numNbrs;
    }

    public void setNumNbrs(int numNbrs) {
        this.numNbrs = numNbrs;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    Cell() {
    }

    //ML Cell
    public Cell(int y, int x) {
        alive = true;
        xCoord = x;
        yCoord = y;
    }

    @Override
    public String toString() {
        //return "Cell{" + "numNbrs=" + numNbrs + ", alive=" + alive + '}';
        return "Cell{" + "xCoord=" + xCoord + ", yCoord=" + yCoord + '}'; //ML version
    }

    char display() {
        if (alive) {
            return ALIVE;
        }
        return DEAD;
    }

    void update() {
        alive = (numNbrs == 3 || alive && numNbrs == 2);
    }

}

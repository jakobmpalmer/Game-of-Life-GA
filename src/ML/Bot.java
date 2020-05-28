package ML;

import Game.Life;
import Game.Cell;
import java.util.Random;

/**
 * @author jakepalmer
 */
public class Bot {

    boolean DEBUG = false;

    //member vars
    Cell[] dna; //not life.. seed for life? int? ((cells?)) 
    Life botLife;
    String botName;
    int fitness; //num cells
    int rSum;
    boolean rightSide;

    private int countCellsCount = 0;

    //CONSTRUCTORS
    public Bot() {
    }

    //Main Const
    public Bot(Life someLife, boolean rSide) {
        botName = getName();
        botLife = someLife;
        rightSide = rSide;
    }

    public Bot(Life someLife, boolean rSide, String n) {
        botName = n;
        botLife = someLife;
        rightSide = rSide;
        fitness = getFitness();
    }

    //Clone 
    public Bot(Bot aBot) {
        botName = aBot.getName();
        rightSide = aBot.getSide();
        dna = aBot.getDNA();
        rSum = aBot.getRSum();
        botLife = aBot.getLife();
        fitness = aBot.getFitness();
    }
//----------------------------------------------------------------------------------

    //-----------------------------------------
    //------------------------------|----------
    //METHODS|----------------------|----------
    //------------------------------V----------
    //-----------------------------------------
    public int countCells() {
        Cell[][] ourCells = botLife.getCells();
        int cellCount = 0;
        int jOffset = getSide() ? 0 : (ourCells[0].length / 2);

        if (DEBUG) {
            System.out.println("---> COUNTING - countCells() : Bot.java - Times Called : "
                    + countCellsCount + "----------------");
            System.out.println("getSide()" + getSide());
            System.out.println("ourCells[0].length/2 = " + ourCells[0].length / 2);
            System.out.println("end countCells() <---");
            countCellsCount++;
        }

        for (int i = 0; i < botLife.getN(); i++) { //Y
            int size = (getSide()) ? botLife.getN() : botLife.getXN();
            for (int j = (0 + jOffset); j < size; j++) { //X
                if (ourCells[i][j].isAlive()) {
                    cellCount++;
                    //System.out.println("j = " + j);
                    //System.out.println("Cell @ [" + j + "][" + i + "]");
                }
            }
        }
        return cellCount;
    }

    //INIT With sides
    public void init(Cell[][] ourCells, int cellNum, boolean sideRight) {
        String botSide = (sideRight) ? "Right" : "Left";

        setRandomCells(ourCells, cellNum, sideRight);

        if (DEBUG) {
            System.out.println("----------------------------------\nINIT BEGUN: Bot [" + botSide
                    + "]\n----------------------------------");
            System.out.println("countCells() = " + countCells());
            System.out.println("Cell Num = " + cellNum);
            System.out.println("----------------------------------\nINIT END: Bot[" + botSide
                    + "]\n----------------------------------");
        }
    }

    public void setRandomCells(Cell[][] someCells, int numCells, boolean side) {
        Random r = new Random();
        int sideOffset = (side) ? someCells[0].length / 2 : 0;

        Cell[] initCells = new Cell[numCells];
        dna = new Cell[numCells]; //ArrayList?
        int i = 0;
        while (i < numCells) {
            //for (int i = 0; i < numCells; i++) {            
            int randX = r.nextInt(someCells.length - 1) + sideOffset;
            int randY = r.nextInt(someCells.length - 1);

            Cell theCell = new Cell(randY, randX);

            //Attempt at consistent 15 cell spawn
//            for (int j = 0; j < dna.length; j++) {
//                System.out.println("NumCells " + numCells);
//                System.out.println("\t dd" + j);
//                System.out.println("FINDME");
//                System.out.println("theCell = " + theCell.toString());
//                System.out.println("dna[j] " + dna[j]);
//                if (theCell == dna[j]) {
//                    System.out.println("Caught one!");
//                    //return;
//                    i -= 1;
//                }
//            }
            dna[i] = theCell;
            initCells[i] = someCells[randY][randX];

            someCells[randY][randX].setAlive(true);

            if (DEBUG) {
                //System.out.println("someCells.length = " + someCells.length);
                //System.out.println(someCells.length + "/" + xOffset + " - 1");
                System.out.println("sideOffset = " + sideOffset);
                System.out.println("randX = " + randX);
                //System.out.println(someCells.length + " - 1 + " + yOffset);
                System.out.println("randY = " + randY);
                System.out.println("-----------------------------");
            }

            i++;

        }
    }

    public void mutate() {
        Cell[] thisDna = this.getDNA();
        Cell[] newDna = new Cell[thisDna.length + 1];
        newDna = thisDna;
        Random rand = new Random();
        int randOne = rand.nextInt(thisDna.length);
        int randTwo = rand.nextInt(thisDna.length);
        System.out.println("randTwo = " + randTwo);
        System.out.println("randOne = " + randTwo);
        System.out.println("length " + newDna.length);
        Cell newCell = new Cell(randOne, randTwo);
        System.out.println(newCell.toString());
        newDna[thisDna.length-1] = newCell;
    }

    public void splice(Bot botOne) {
        Cell[] dnaOne = botOne.getDNA();
        //Cell[] dnaTwo = botTwo.getDNA();
        Random rand = new Random();
        System.out.println("dnaOne.length = " + dnaOne.length);
        //System.out.println("dnaTwo.length = " + dnaTwo.length);
        int randOne = rand.nextInt(dnaOne.length);
        int randTwo = rand.nextInt(dnaOne.length);
        for (int i = 0; i < dnaOne.length; i++) {
            for (int j = 0; j < dnaOne.length; j++) {

            }
        }
        //dnaOne.toString();
    }
//----------------------------------------------------------------------------------

    //------------------------------------------------------------------------
    //TOSTRING
    //------------------------------------------------------------------------
    public String toString() {
        return getName() + " : Fitness: " + getFitness() + " rSum: " + rSum;
    }

    //------------------------------------------------------------------------
    //GETTERS/SETTERS
    //------------------------------------------------------------------------
    public String getName() {
        return botName;
    }

    public Cell[] getDNA() {
        return dna;
    }

    public Life getLife() {
        return botLife;
    }

    public boolean getSide() {
        return rightSide;
    }

    public int getRSum() {
        return rSum;
    }

    public int getFitness() {
        return countCells();
    }

    //------------------------------------------------
    public void setName(String n) {
        botName = n;
    }

    public void setDNA(Cell[] someDna) {
        this.dna = someDna;
    }

    public void setFitness(int f) {
        this.fitness = f;
    }

    public void setRSum(int r) {
        rSum = r;
    }
    
    public void addRSum(int r) {
        rSum += r;
    }
    //------------------------------------------------------------------------
}

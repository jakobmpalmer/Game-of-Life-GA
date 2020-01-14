package ML;

//import ML.Individual;
//import java.util.ArrayList;
import Game.Life;
import ML.Bot;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jakepalmer
 */
public class TournDirector {

//----| Global Vars |-----------------------------------------------
    int numBots = 50;
    //int mpSize = (int) (numBots *.25);
    //int mpSize = 6;
    int mpSize = numBots;

//----MEMBER VARS---------------------------------------------------
    Boolean DEBUG = true;

    //Individual[] matingPool;
    Bot[] matingPool;

    GameDirector ourGD;

//------------------------------------------------------------------------------
//----| Our Friendly Bots | findBots -------------------------------------------
//------------------------------------------------------------------------------
    Life myLife = new Life();
//NOT THE SAME LIFE AS myLife IN MAINFRAME
    Bot bob_Bot = new Bot(myLife, false, "bob_bot"); //Left
    Bot lizzy_Bot = new Bot(myLife, false, "lizzy_Bot"); //Left
    Bot sylvie_Bot = new Bot(myLife, false, "sylvie_Bot"); //Left

    Bot steven_Bot = new Bot(myLife, true, "steven_Bot"); //Right
    Bot kyle_Bot = new Bot(myLife, true, "kyle_Bot"); //Right
    Bot rosie_Bot = new Bot(myLife, true, "rosie_Bot"); //Right

//------------------------------------------------------------------------------
//----| CONSTRUCTORS : findConstructors |---------------------------------------
//------------------------------------------------------------------------------    
    public TournDirector() {
        ourGD = new GameDirector();
        matingPool = new Bot[mpSize];
    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
//----| METHODS |---------------------------------------------------------------
//------------------------------------------------------------------------------
    public Bot[] createBotList() {

        Bot[] botList = new Bot[numBots];
        //System.out.println("CreatingBotList " + botList.length);
        botList[0] = bob_Bot;
        botList[1] = steven_Bot;
        botList[2] = lizzy_Bot;
        botList[3] = kyle_Bot;
        botList[4] = sylvie_Bot;
        botList[5] = rosie_Bot;
        return botList;
    }

    public Bot[] createBotList(int n) {
        Bot[] botList = new Bot[n];
        String name = "";
        boolean side;
        for (int i = 0; i < n; i++) {
            name = "";
            name = name.concat("Bot_" + i);
            side = (i % 2 == 0) ? true : false;
            botList[i] = new Bot(myLife, side, name);
        }

        for (int i = 0; i < botList.length; i++) {
            System.out.println("\n\t" + botList[i].toString());
        }

        return botList;
    }

    public Bot[] SelectMatingPool(Bot[] ourList) {
        int sum = 0;
        Bot clone;

        int rand;
        Bot currIndiv;
        //Bot clone;

        //evaluate fitness for each individual
        for (int i = 0; i < ourList.length; i++) {
            sum += ourList[i].countCells(); //Bound Must be positive            
            //ourList[i].setRSum(sum);
            ourList[i].addRSum(sum);
        }

        //select mating pool
        //(-1) to normalize the loop to our array
        // for (int mpCount = 0; mpCount < matingPool.length; mpCount++) {
        int mpCount = 0;
        //System.out.println("mpCount = " + mpCount + " matingPool.Length " + matingPool.length);

        //------------------------------------------------------------------
        for (int i = 0; i < ourList.length; i++) {
            //for (int i = 0; i < matingPool.length; i++) {
            Random r = new Random();
            rand = r.nextInt(sum - 1);
            System.out.println("RAND = " + rand);
            //System.out.println("ourList[i] " + ourList[i]);
            currIndiv = ourList[i];

            System.out.println("WHILE {");
            while (currIndiv.rSum < rand) { //Loops until current individual rSum is greater than our rand
                currIndiv.toString();
                System.out.println("\t" + currIndiv.getName() + "-------");
                System.out.println("\tcurrIndiv.rSum " + currIndiv.rSum + " RandomTarget= " + rand);

                //System.out.println(currIndiv.name + " rsum= " + currIndiv.rSum + " :: RandomTarget= " + rand);
                currIndiv = ourList[i++];
            }
            System.out.println("}\n");
            //------------------------------------------------------------------

            clone = new Bot(currIndiv); //????                
            //matingPool[mpCount] = currIndiv;
            matingPool[mpCount] = clone;

            if (DEBUG) {
                System.out.println("\n---------------");
                System.out.println("----| BOT |----");
                System.out.println("ADDED " + matingPool[mpCount].getName() + ", with " + currIndiv.rSum + ">" + rand);
                System.out.println(clone.toString());
                System.out.println("---------------");

                System.out.println("\n----| MatingPool |----");
                System.out.println("matingPool.length = " + matingPool.length);
                System.out.println("mpCount = " + mpCount);
//                  System.out.println("matingPool[mpCount].dna = " + matingPool[mpSize].dna);
            }
            //---------------------
            //INCREMENT------------
            //mpSize++;
            mpCount++;
            //---------------------

        } //for (ourList)
        return matingPool;
        //} // for(mpcount)
    } //SelectMatingPool()

    public void printMatingPool() {
        System.out.println("----| PRINTING matingPool |----------------------------------");
        for (int i = 0; i < matingPool.length; i++) {

            try {
                System.out.println("\t" + matingPool[i].toString());
            } catch (NullPointerException e) {
                //System.out.println("\tNULLPOINTER");
                break;
            }
        }
    }

    public Bot[] getBestTwo(Bot[] botList) {
        Bot[] bestTwo = new Bot[2];
        Bot[] tempBots = new Bot[2];
        Bot tempBot;

        for (int i = 0; i < 2; i++) {

            bestTwo[i] = new Bot(botList[i]);
        }

        for (int i = 0; i < botList.length; i++) {
            try {
                for (int j = 0; j < bestTwo.length; j++) {
                    tempBot = new Bot(botList[i]);
                    //System.out.println("botList[i].getDna().toString() = \n" + botList[i].getDNA().toString());
                    if ((tempBot.getFitness() < bestTwo[j].getFitness()) &&
                            (tempBot.getName() != bestTwo[0].getName())) {
                        bestTwo[j] = tempBot;
                        System.out.println("PLAYER ADDED: " + botList[i].getName() + ", over, " + tempBot.getName());
                    }

                }
            } catch (NullPointerException e) {
                break;
            }
        }

        return bestTwo;

    }
//-------------------------------------------------------------
//GETTERS SETTERS----------------------------------------------
//-------------------------------------------------------------

    public Bot[] getMatingPool() {
        return matingPool;
    }

    public void setMatingPool(Bot[] matingPool) {
        this.matingPool = matingPool;
    }

    public GameDirector getOurGD() {
        return ourGD;
    }

    public Life getLife() {
        return myLife;
    }

    public int getNumBots() {
        return numBots;
    }

}

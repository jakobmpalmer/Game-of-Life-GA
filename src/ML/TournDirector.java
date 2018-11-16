package ML;

import java.util.ArrayList;
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

//MEMBER VARS---------------------------------------------------
    Boolean DEBUG = false;

    Individual[] matingPool;
    int mpSize = 7;
    GameDirector ourGD;

    private final int[] indyDNA = {0, 0, 1,}; //1
    private final int[] catDNA = {0, 1, 1}; //2
    private final int[] dogDNA = {1, 1, 1}; //3
    private final int[] iguDNA = {1, 1, 1, 1, 1, 1, 1, 1, 1}; //9
    private final int[] fishDNA = {1, 1, 1, 0, 0, 0, 1}; //3
    private final int[] monkeyDNA = {1, 1, 0, 1, 0, 0, 1, 1, 1}; //6
    private final int[] snakeDNA = {0, 0, 0, 0, 0, 0, 1, 1, 1}; //3

    Individual indy = new Individual("indy", indyDNA);
    Individual cat = new Individual("cat", catDNA);
    Individual dog = new Individual("dog", dogDNA);
    Individual iguana = new Individual("iguana", iguDNA);
    Individual fish = new Individual("fish", fishDNA);
    Individual monkey = new Individual("monkey", monkeyDNA);
    Individual snake = new Individual("snake", snakeDNA);

    Individual[] indList = new Individual[mpSize];

//CONSTRUCTORS-------------------------------------------------
    public TournDirector() {
        ourGD = new GameDirector();
        matingPool = new Individual[mpSize];
        createIndList();
    }

//METHODS------------------------------------------------------
    public Individual[] createIndList() {

        indList[0] = indy;
        indList[1] = cat;
        indList[2] = dog;
        indList[3] = iguana;
        indList[4] = fish;
        indList[5] = monkey;
        indList[6] = snake;

        return indList;

    }

//    create initial population
//	while (!done) {
//		apply genetic operators to mating pool to create new individuals
//		replacement
//	}
//	report results
    public void SelectMatingPool(Individual[] ourList) {
        int sum = 0;
        int mpCount = 0;
        //int mpCount = mpSize;
        int rand;
        Individual currIndiv;
        Individual clone;
//		evaluate fitness for each individual
        for (int i = 0; i < ourList.length; i++) {
            sum += ourList[i].countOnes();                        
            ourList[i].setRSum(sum);            
        }

//		select mating pool
        for (int i = 0; i < matingPool.length; i++) {
            Random r = new Random();
            rand = r.nextInt(sum - 1);
            System.out.println("rand = " + rand);
            currIndiv = ourList[i];
            while (currIndiv.rSum < rand) {
                System.out.println(currIndiv.name + " rsum" + currIndiv.rSum + "::" + rand);
                currIndiv = ourList[i++];
            }
            System.out.println("ADDED " + currIndiv.name + ", with " + currIndiv.rSum + ">" + rand);
            clone = new Individual(currIndiv);
            matingPool[mpCount] = currIndiv;
            mpCount++;
        }

    }

    public Individual[] createMatingPool() {
        Individual winner;
        for (int i = 0; i < indList.length; i++) {
            for (int j = 0; j < indList.length; j++) {
                if (indList[i] == indList[j]) {
                    continue; //tie
                } else {
                    if (DEBUG) {
                        System.out.println("------------------------------------");
                        System.out.println("i = " + i + ", j = " + j);
                        System.out.println("[i] = " + indList[i].getName() + ", [j] = " + indList[j].getName());
                        System.out.println("------------------------------------");
                    }
                    //winner = ourGD.eval(indList[i], indList[j]);
                    //System.out.println("Winner = " + winner.getName());
                    //matingPool.add(winner);
                }
            }
        }
        return matingPool;
    }

    public void printMatingPool() {
        System.out.println("MatingPool----------------------------------");
        for (int i = 0; i < matingPool.length; i++) {

            try {
                System.out.println("\t" + matingPool[i].toString());
            } catch (NullPointerException e) {
                //System.out.println("\tNULLPOINTER");
                break;
            }
        }
        System.out.println("--------------------------------------");
    }

//GETTERS SETTERS----------------------------------------------
    public Individual[] getMatingPool() {
        return matingPool;
    }

    public void setMatingPool(Individual[] matingPool) {
        this.matingPool = matingPool;
    }

    public GameDirector getOurGD() {
        return ourGD;
    }

    public Individual[] getIndList() {
        return indList;
    }

    public void setIndList(Individual[] indList) {
        this.indList = indList;
    }

}

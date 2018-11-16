/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ML;

/**
 *
 * @author jakepalmer
 */
public class Individual {

    int fitness;
    int dna[];
    String name;
    int rSum;

    //Constructors--------------------
    public Individual() {
    }

    public Individual(String n) {
        name = n;
    }

    public Individual(int[] dna) {
        this.dna = dna;
        rSum = 0;
    }
    
    public Individual(String name, int[] dna) {
        this.dna = dna;
        this.name = name;
        rSum = 0;     
        fitness = getFitness();
    }
    
    public Individual(Individual indiv){
        this.dna = indiv.getDNA();
        this.name = indiv.getName();
        this.rSum = indiv.rSum;
    }
    
    

    //--------------------------------
    //METHODS
    public int countOnes() {
        int ones = 0;
        for (int i = 0; i < dna.length; i++) {
            if (dna[i] == 1) {
                ones++;
            }
        }

        return ones;
    }
    
    public String getName(){
        return name;
    }
    
    public int[] getDNA(){
        return dna;
    }
    
    
    
    
    //TOSTRING
    public String toString(){
        return getName() + ": Fitness: " + getFitness() + " rSum: " + rSum;
    }

    public int getFitness() {
        return countOnes();
    }
    
    public void setFitness(int f){
        this.fitness = f;
    }
    
    public void setRSum(int r){
        rSum = r;
    }

}

package ML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jakepalmer
 */
public class GameDirector {

    int fit;
    
    
    public GameDirector() {

    }

    public Individual eval(Individual indOne, Individual indTwo) {
        int oneCount = indOne.countOnes();
        int twoCount = indTwo.countOnes();
        if (oneCount > twoCount) {
            return indOne;
        }else if (oneCount < twoCount){
            return indTwo;
        } else {
            System.out.println("TIE");
            return indOne;
        }
               
    }
}

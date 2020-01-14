package ML;

//import ML.Individual;

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
    

    public GameDirector() {

    }  

    public Bot evalBots(Bot botOne, Bot botTwo) {
        int oneCount = botOne.countCells();
        int twoCount = botTwo.countCells();
        if (oneCount > twoCount) {
            return botOne;
        } else if (oneCount < twoCount) {
            return botTwo;
        } else {
            System.out.println("BOTS_TIE");
            return botOne;
        }

    }

}

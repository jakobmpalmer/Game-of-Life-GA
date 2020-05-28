package ML;

/**
 * @author jakepalmer
 * The Game Director is responsible for reporting the winner of each game.
 * The result of this class is given to the future generation of bots to get the
 * best available DNA.
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

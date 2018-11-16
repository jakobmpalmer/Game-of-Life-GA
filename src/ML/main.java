/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ML;





public class main {
       

    public static void main(String[] args) {     
                
                        System.out.println("start");
        
        TournDirector theTD = new TournDirector();
        Individual[] theList = theTD.createIndList();
        //Individual[] theList = theTD.getIndList();        
//        theTD.createMatingPool();        
        theTD.SelectMatingPool(theList);        
        theTD.printMatingPool();
        
        

    }

}

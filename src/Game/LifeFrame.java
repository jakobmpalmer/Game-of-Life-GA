package Game;

import ML.TournDirector;
import ML.Bot;
import javax.swing.SwingUtilities;

public class LifeFrame extends javax.swing.JFrame {

    //----| Global Vars |-----------------------------------------------
    private int gameSize = 2;
    private int initSize = 100;
    int gameLength = 10;
    //------------------------------------------------------------------
    boolean DEBUG = true;
    //ML
    TournDirector theTD = new TournDirector();
    Bot[] botList;
    Bot[] matingPool;
    Bot[] newGen;
    Bot[] bestTwo;
    private final Life myLife;
    //private final Bot bot1;
    //private final Bot bot2;
    Bot[] players;
    private int stepCount;

    private boolean dispBar = true;

    public LifeFrame() {
        initComponents();
        setTitle("Game of Conways game of life!");
        GameLengthTF.setText("50");
        setSize(800, 800);
        ///myLife = new Life();
        myLife = theTD.getLife();
        matingPool = new Bot[theTD.getNumBots()];
        newGen = new Bot[theTD.getNumBots()];
        bestTwo = new Bot[2];
        //botList = theTD.createBotList();
        botList = theTD.createBotList(theTD.getNumBots());
        players = new Bot[2];

        //----| ML |------------------
        for (int i = 0; i < botList.length; i++) {

            botList[i].init(botList[i].getLife().getCells(),
                    initSize, botList[i].getSide()); //DEBUG version
        }

        if (DEBUG) {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("-----|theTD.selectMatingPool() : LifeFrame.java |---------");
            System.out.println("----------------------------------------------------------");
            matingPool = theTD.SelectMatingPool(botList);
            System.out.println("----------------------------------------------------------");

            System.out.println("\n----------------------------------------------------------");
            System.out.println("-----|theTD.printMatingPool() : LifeFrame.java |----------");
            System.out.println("----------------------------------------------------------");
            theTD.printMatingPool();
            System.out.println("----------------------------------------------------------");

        } else {
            matingPool = theTD.SelectMatingPool(botList);
            theTD.printMatingPool();
        }
        newGen = matingPool.clone();
        myLife.zeroCells();
        //----| GAME |----------------

        System.out.println("----| GAME INITIALIZATION BEGIN |----------------");
        System.out.println("---------------------------------------------------");
        //Add players
        System.out.println("ADDING Players");
        //for (int i = 0; i < gameSize; i++) {
        //Bot tempOne, tempTwo;
        Bot[] tempBot = new Bot[players.length];
        for (int i = 0; i < 2; i++) {
            tempBot[i] = botList[i];
            players[i] = botList[i];
        }

        bestTwo = theTD.getBestTwo(matingPool);

        for (int i = 0; i < gameSize; i++) {

            players[i].init(players[i].getLife().getCells(),
                    initSize, players[i].getSide()); //DEBUG version
        }

//        PlayerOneNameLabel.setText(players[0].getName());
//        PlayerTwoNameLabel.setText(players[1].getName());
        replacePlayers();

        updateTDirTA();
        updateCount();
        displayBar();
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        theTA = new javax.swing.JTextArea();
        stepButton = new javax.swing.JButton();
        countLabel = new javax.swing.JLabel();
        CountTFTwo = new javax.swing.JTextField();
        PlayerOneNameLabel = new javax.swing.JLabel();
        PlayerTwoNameLabel = new javax.swing.JLabel();
        CountTFOne = new javax.swing.JTextField();
        BarBtn = new javax.swing.JButton();
        InitBtn = new javax.swing.JButton();
        GameLengthTF = new javax.swing.JTextField();
        RunSlider = new javax.swing.JSlider();
        ClearBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TDirTA = new javax.swing.JTextArea();
        PlayBtn = new javax.swing.JButton();
        GenBtn = new javax.swing.JButton();
        XGenBtn = new javax.swing.JButton();
        XGenTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        theTA.setColumns(20);
        theTA.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        theTA.setRows(5);
        jScrollPane1.setViewportView(theTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 540, 560);

        stepButton.setText("Step");
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stepButton);
        stepButton.setBounds(600, 50, 100, 32);

        countLabel.setText("Steps: ");
        getContentPane().add(countLabel);
        countLabel.setBounds(610, 90, 80, 16);
        getContentPane().add(CountTFTwo);
        CountTFTwo.setBounds(650, 240, 40, 24);

        PlayerOneNameLabel.setText("Player1");
        getContentPane().add(PlayerOneNameLabel);
        PlayerOneNameLabel.setBounds(580, 200, 60, 16);

        PlayerTwoNameLabel.setText("Player2");
        getContentPane().add(PlayerTwoNameLabel);
        PlayerTwoNameLabel.setBounds(580, 240, 70, 16);

        CountTFOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountTFOneActionPerformed(evt);
            }
        });
        getContentPane().add(CountTFOne);
        CountTFOne.setBounds(650, 200, 40, 24);

        BarBtn.setText("Bar");
        BarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BarBtn);
        BarBtn.setBounds(640, 690, 70, 32);

        InitBtn.setText("Init");
        InitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(InitBtn);
        InitBtn.setBounds(600, 110, 100, 32);

        GameLengthTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameLengthTFActionPerformed(evt);
            }
        });
        getContentPane().add(GameLengthTF);
        GameLengthTF.setBounds(590, 390, 120, 24);

        RunSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RunSliderStateChanged(evt);
            }
        });
        getContentPane().add(RunSlider);
        RunSlider.setBounds(590, 420, 120, 16);

        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ClearBtn);
        ClearBtn.setBounds(650, 350, 70, 32);

        TDirTA.setColumns(20);
        TDirTA.setRows(5);
        jScrollPane2.setViewportView(TDirTA);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(23, 640, 550, 83);

        PlayBtn.setText("Play");
        PlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PlayBtn);
        PlayBtn.setBounds(564, 350, 90, 32);

        GenBtn.setText("Next Gen");
        GenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenBtnActionPerformed(evt);
            }
        });
        getContentPane().add(GenBtn);
        GenBtn.setBounds(600, 490, 100, 32);

        XGenBtn.setText("__ Gen");
        XGenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XGenBtnActionPerformed(evt);
            }
        });
        getContentPane().add(XGenBtn);
        XGenBtn.setBounds(597, 530, 100, 32);

        XGenTF.setText("10");
        XGenTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XGenTFActionPerformed(evt);
            }
        });
        getContentPane().add(XGenTF);
        XGenTF.setBounds(600, 570, 90, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//------------------------------------------------------------------------------
//| BUTTONS |-------------------------------------------------------------------
//------------------------------------------------------------------------------

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtonActionPerformed
        stepCount++;
        myLife.step();
        updateCount();
        display();
        countLabel.setText("Steps: " + stepCount);
        updateTDirTA();
    }//GEN-LAST:event_stepButtonActionPerformed

    private void BarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarBtnActionPerformed
        // TODO add your handling code here:
        dispBar = !dispBar;
        myLife.toStringBar(dispBar);
        displayBar();
    }//GEN-LAST:event_BarBtnActionPerformed

    private void InitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitBtnActionPerformed
        executeInitBtn();
    }//GEN-LAST:event_InitBtnActionPerformed

    private void GameLengthTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameLengthTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GameLengthTFActionPerformed

    private void CountTFOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountTFOneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CountTFOneActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        myLife.zeroCells();
        display();
        updateCount();
        updateTDirTA();
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void PlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayBtnActionPerformed
        // TODO add your handling code here:
        executePlayBtn();
    }//GEN-LAST:event_PlayBtnActionPerformed

    private void RunSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RunSliderStateChanged
        // TODO add your handling code here:
        GameLengthTF.setText("" + RunSlider.getValue());
    }//GEN-LAST:event_RunSliderStateChanged

    private void GenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenBtnActionPerformed
        // TODO add your handling code here:     
        executeInitBtn();
        executePlayBtn();
        executeGenBtn();

    }//GEN-LAST:event_GenBtnActionPerformed

    private void XGenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XGenBtnActionPerformed
        // TODO add your handling code here:

        int numGens = Integer.valueOf(XGenTF.getText());
        XGenBtn.setText(numGens + " Gens");
        for (int i = 0; i < numGens; i++) {
            executeInitBtn();
            executePlayBtn();
            executeGenBtn();
        }
    }//GEN-LAST:event_XGenBtnActionPerformed

    private void XGenTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XGenTFActionPerformed
        // TODO add your handling code here:
        XGenBtn.setText((XGenTF.getText() + " Gens"));
    }//GEN-LAST:event_XGenTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BarBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextField CountTFOne;
    private javax.swing.JTextField CountTFTwo;
    private javax.swing.JTextField GameLengthTF;
    private javax.swing.JButton GenBtn;
    private javax.swing.JButton InitBtn;
    private javax.swing.JButton PlayBtn;
    private javax.swing.JLabel PlayerOneNameLabel;
    private javax.swing.JLabel PlayerTwoNameLabel;
    private javax.swing.JSlider RunSlider;
    private javax.swing.JTextArea TDirTA;
    private javax.swing.JButton XGenBtn;
    private javax.swing.JTextField XGenTF;
    private javax.swing.JLabel countLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton stepButton;
    private javax.swing.JTextArea theTA;
    // End of variables declaration//GEN-END:variables

    //----| Shortcuts |------------------------------------
    public void updateCount() {
        CountTFTwo.setText(String.valueOf(players[0].countCells()));
        CountTFOne.setText(String.valueOf(players[1].countCells()));
    }
    //-----------------------------------------------------

    private void display() {
        theTA.setText(myLife.toString());
    }

    private void displayBar() {
        theTA.setText(myLife.toStringBar(dispBar));
    }

    public void updateTDirTA() {

        TDirTA.setText("");
        TDirTA.append("--| Mating Pool |----------------------"
                + "--------------------------\n");
        for (int i = 0; i < theTD.getMatingPool().length; i++) {
            try {
                if (newGen[i] == null) {
                    break;
                }
                TDirTA.append("\t" + newGen[i] + "\n");
            } catch (NullPointerException e) {
                //System.out.println("\tNULLPOINTER");
                break;
            }
        }

        TDirTA.append("--| Best Two |----------------------"
                + "--------------------------\n");
        bestTwo = theTD.getBestTwo(newGen);
        for (int i = 0; i < 2; i++) {
            TDirTA.append("\t" + bestTwo[i].toString() + "\n");
        }

    }

    public void replacePlayers() {
        for (int i = 0; i < 2; i++) {
            players[i] = bestTwo[i];
            System.out.println("\n\t RIght HERE" + players[i].getName());
        }
        PlayerOneNameLabel.setText(players[0].getName());
        PlayerTwoNameLabel.setText(players[1].getName());
        CountTFOne.setText("" + players[0].getFitness());
        CountTFTwo.setText("" + players[1].getFitness());
    }

    private void executePlayBtn() {
        int count = Integer.parseInt(GameLengthTF.getText());

        for (int i = 0; i < count; i++) {
            //for (int i = 0; i < gameLength; i++) {
            stepCount++;
            myLife.step();

            updateCount();
            updateTDirTA();
            displayBar();
            countLabel.setText("Steps: " + stepCount);
        }

        newGen = matingPool;
        theTD.getBestTwo(botList);
        //newGen[0].splice(newGen[0], newGen[1]);
        replacePlayers();
        updateTDirTA();
        updateCount();
        
        displayBar();
    }

    //Create a new game
    private void executeInitBtn() {
        myLife.zeroCells();
        stepCount = 0;
        countLabel.setText("Steps: 0");
        //for (int i = 0; i < botList.length; i++) {
        for (int i = 0; i < players.length; i++) {
            //botList[i].setRandomCells(myLife.getCells(), initSize, botList[i].getSide());
            matingPool[i].setRandomCells(myLife.getCells(), initSize, botList[i].getSide());
        }
        updateCount();
        updateTDirTA();        
        displayBar();
                
    }

    private void executeGenBtn() {
        for (int i = 0; i < newGen.length; i++) {
            newGen[i] = matingPool[i];
        }

        //matingPool;
        for (int i = 0; i < newGen.length; i++) {

            try {
                newGen[i].mutate();
            } catch (NullPointerException e) {
                break;
            }
            //newGen[i] = newGen[i].splice(bestTwo[0]);

        }

        bestTwo = theTD.getBestTwo(newGen);
        replacePlayers();
        updateTDirTA();
        updateCount();
    }

    public void evalFitness(Bot[] someBots) {
        for (int i = 0; i < someBots.length; i++) {
            someBots[i].addRSum(someBots[i].countCells());
        }
    }

}

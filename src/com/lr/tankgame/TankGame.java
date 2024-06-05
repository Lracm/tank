package com.lr.tankgame;

import javax.swing.*;

/**
 * @author LR
 * @version 1.0
 * @Date 2024/6/5 18:59
 */
public class TankGame extends JFrame {
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame();

    }

    public TankGame(){
        myPanel = new MyPanel();

        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

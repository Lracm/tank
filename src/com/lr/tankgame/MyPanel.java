package com.lr.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author LR
 * @version 1.0
 * @Date 2024/6/5 18:58
 */
public class MyPanel extends JPanel implements KeyListener {
    LcTank lcTank =null;


    //定义敌方坦克放入Vector 多线程
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 4;

    public MyPanel(){
        lcTank = new LcTank(100,100);
        lcTank.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(0,0,1000,750);

        drawTank(lcTank.getX(), lcTank.getY(),g,lcTank.getDirect(),0);

        //画出敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }

    }

    /***
     *
     * @param x x坐标
     * @param y 坐标
     * @param g 画笔
     * @param direct 方向
     * @param type 类型 0我方坦克 1敌方坦克
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
               // g.setColor(Color.yellow);
                //libpng warning: iCCP: known incorrect sRGB profile
                g.setColor(Color.YELLOW);
                break;
        }
        switch (direct){
            case 0:
                g.draw3DRect(x,y,10,60,false); //向上左边轮胎
                g.draw3DRect(x+30,y,10,60,false);//向上右边轮胎
                g.draw3DRect(x+10,y+10,20,40,false);//向上车身
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1: //右
                g.draw3DRect(x,y,60,10,false);
                g.draw3DRect(x,y+30,60,10,false);
                g.draw3DRect(x+10,y+10,40,20,false);
                g.drawOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2:
                g.draw3DRect(x,y,10,60,false); //向下左边轮胎
                g.draw3DRect(x+30,y,10,60,false);//向下右边轮胎
                g.draw3DRect(x+10,y+10,20,40,false);//向下车身
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3:
                g.draw3DRect(x,y,60,10,false);
                g.draw3DRect(x,y+30,60,10,false);
                g.draw3DRect(x+10,y+10,40,20,false);
                g.drawOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
            default:
                System.out.println("~~~");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘按下监听触发监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() ==KeyEvent.VK_W){
            lcTank.setDirect(0);
            lcTank.moveUp();
        }else if(e.getKeyCode() ==KeyEvent.VK_D){
            lcTank.setDirect(1);
            lcTank.moveRight();
        }else if(e.getKeyCode() ==KeyEvent.VK_S){
            lcTank.setDirect(2);
            lcTank.moveDown();
        }else if(e.getKeyCode() ==KeyEvent.VK_A){
            lcTank.setDirect(3);
            lcTank.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

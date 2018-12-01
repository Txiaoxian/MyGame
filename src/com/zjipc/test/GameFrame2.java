package com.zjipc.test;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着各种轨迹移动
 * @author Txiao
 */
public class GameFrame2 extends Frame{



    Image img = GameUtil.getImage("images/2018.11.25.png");

    public static void main(String[] args) {
        GameFrame2 gf = new GameFrame2();
        gf.launchFrame();
    }


    /**
     * 加载窗口
     */
    public void launchFrame(){
        setLocation(100,100);
        setSize(500,500);
        setVisible(true);

        new PaintThread().start();  //启动重画线程

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    private int x=200;
    private int y=200;
    private boolean left;
    @Override
    public void paint(Graphics g) {

        g.drawImage(img,x,y,null);
        if (left) y-=6;
        else y+=6;
        if (y>500-60) left=true;
        else if (y<30) left=false;
    }

    /**
     * 定义一个重画窗口的线程类，是一个内部类。
     */
    class PaintThread extends Thread{

        public void run(){
            while (true){
                repaint();
                try {
                    Thread.sleep(33);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

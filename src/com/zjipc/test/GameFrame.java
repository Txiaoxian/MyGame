package com.zjipc.test;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏基本知识测试类
 * @author Txiao
 */
public class GameFrame extends Frame{



    Image img = GameUtil.getImage("images/2018.11.25.png");

    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
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

    int x=200;
    int y=200;
    @Override
    public void paint(Graphics g) {
        g.drawLine(100,100,200,200);
        g.drawRect(100,100,200,200);
        g.drawOval(100,100,200,200);

        Font f = new Font("宋体",Font.BOLD,50);
        g.setFont(f);
        g.drawString("1232223",200,200);

        g.fillRect(100,100,20,20);
        Color c = g.getColor();

        g.setColor(Color.red);
        g.fillOval(200,100,60,60);
        g.fill3DRect(300,100,60,60,false);

        g.setColor(c);

        g.drawImage(img,x,y,null);
        x++;
        y+=3;
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

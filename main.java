package javaapplication2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Max
 */
public class main {
    public static void main(String[] args){
        List<Bullet> bullets = new LinkedList<Bullet>();
        Player1 player1 = new Player1(300, 300, 1920, 1080, bullets);
        Background bg = new Background();
        
        Frame f = new Frame(player1, bg, bullets);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setUndecorated(true);
     //   f.setVisible(true);
        f.setResizable(true);
        DisplayMode displayMode = new DisplayMode(1920, 1080, 16, 75);
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        
        device.setFullScreenWindow(f);
        //device.setDisplayMode(displayMode);
       
       f.makeStrat();
        
        long lastFrame = System.currentTimeMillis();
        while(true){
            long thisFrame = System.currentTimeMillis();
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
            lastFrame=thisFrame;
            
            player1.update(timeSinceLastFrame);
            
            
            
            f.repaintScreen();
            
            for(int i = 0; i<bullets.size(); i++){
                bullets.get(i).update(timeSinceLastFrame);
            }
            
            
            try {
            Thread.sleep(15);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
}
}
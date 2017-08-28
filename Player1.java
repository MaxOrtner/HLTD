/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Max
 */
public class Player1 {
    private Rectangle bounding;
    private float f_posx;
    private float f_posy;
    private int worldsize_x;
    private int worldsize_y;
    private BufferedImage look;
    private List<Bullet> bullets;
    private float timeSinceLastShot = 0;
    private final float SHOTFREQUENZY = 0.5f;
    public Player1(int x, int y, int worldsize_x, int worldsize_y, List<Bullet> bullets){
        try{
        look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/gordon15prozent.png"));
        } catch(IOException e) {e.printStackTrace();}
      bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
      f_posx = x;
      f_posy = y;
      this.worldsize_x = worldsize_x;
      this.worldsize_y = worldsize_y;
      this.bullets = bullets;
      }
    
    public void update(float timeSinceLastFrame){
            timeSinceLastShot+=timeSinceLastFrame;
            if(Keyboard.isKeyDown(KeyEvent.VK_W))f_posy-=300*timeSinceLastFrame;
            if(Keyboard.isKeyDown(KeyEvent.VK_S))f_posy+=300*timeSinceLastFrame;
            if(Keyboard.isKeyDown(KeyEvent.VK_A))f_posx-=300*timeSinceLastFrame;
            if(Keyboard.isKeyDown(KeyEvent.VK_D))f_posx+=300*timeSinceLastFrame;
            
            if(timeSinceLastShot>SHOTFREQUENZY&&Keyboard.isKeyDown(KeyEvent.VK_SPACE)){
                timeSinceLastShot = 0;
                bullets.add(new Bullet(f_posx+look.getWidth()/2-Bullet.getLook().getWidth()/2, f_posy+look.getHeight()/2, 500, 0, bullets));
                
                
            }
            
            if(f_posx<0)f_posx=0;
            if(f_posy<0)f_posy=0;
            if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;
            if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height;
            
            bounding.x=(int)f_posx;
            bounding.y=(int)f_posy;
  }
    
    public Rectangle getBounding(){
        return bounding;
    }
    
    public BufferedImage getLook(){
        return look;
    }
    
    
}

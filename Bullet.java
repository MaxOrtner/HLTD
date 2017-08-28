
package javaapplication2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.LinkedList;



public class Bullet {
    private static BufferedImage look;
    
    static{
        try{
            look = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("images/bullet.png"));
        
        }catch (IOException e) {e.printStackTrace();}
    }
    
    private float f_posx;
    private float f_posy;
    private float f_speedx;
    private float f_speedy;
    private Rectangle bounding;
    private List<Bullet> bullets;
    private float timeAlive;
    private float TIMETOLIVE = 10;
    
    public Bullet(float x, float y, float speedx, float speedy, List<Bullet> bullets){
        this.f_posx = x;
        this.f_posy = y;
        this.f_speedx = speedx;
        this.f_speedy = speedy;
        bounding = new Rectangle((int)x, (int)y, look.getWidth(), look.getHeight());
        this.bullets = bullets;
    }
    public void update(float timeSinceLastFrame){
        timeAlive+=timeSinceLastFrame;
        if(timeAlive>TIMETOLIVE){
            bullets.remove(this);
        }
        f_posx+=f_speedx*timeSinceLastFrame;
        f_posy+=f_speedy*timeSinceLastFrame;
        bounding.x = (int)f_posx;
        bounding.y = (int)f_posy;
    }
    public Rectangle getBounding(){
        return bounding;
    }
    public static BufferedImage getLook(){
        return look;
    }
    }
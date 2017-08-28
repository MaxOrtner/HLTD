
package javaapplication2;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Background {
    
    private BufferedImage look;
    public Background(){
     try {
        look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/bg1.jpg"));
        } catch(IOException e) {e.printStackTrace();}
    
}
    public BufferedImage getLook(){
        return look;
    }
}

package javaapplication2;



import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.LinkedList;

 
public class Frame extends JFrame{
  
    
    final Player1 player1;
    final Background bg;
    
   
    
    private BufferStrategy strat;
    private List<Bullet> bullets;    
    
    public Frame(Player1 player1, Background bg, List<Bullet> bullets) {
super("HLTD");

addKeyListener(new Keyboard());
this.player1 = player1;
this.bg = bg;
this.bullets = bullets;


                   }
    public void makeStrat(){
        createBufferStrategy(2);
        strat = getBufferStrategy();
    }
    
    public void repaintScreen(){
        Graphics g = strat.getDrawGraphics();
        draw(g);
        g.dispose();
        strat.show();
    }
    private void draw(Graphics g) {
        g.drawImage(bg.getLook(), 0, 0, null);
        for(int i = 0; i<bullets.size(); i++){
            Bullet b = bullets.get(i);
            g.drawImage(Bullet.getLook(), b.getBounding().x, b.getBounding().y, null);
        }
        g.drawImage(player1.getLook(), player1.getBounding().x, player1.getBounding().y, null);
    }
    
    
    
}
    
                                    

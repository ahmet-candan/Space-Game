
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ates {
private int x;
private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class Game extends JPanel implements KeyListener,ActionListener{
    
    Timer timer = new Timer(5, this);
    private int gecen_sure = 0;
    private int harcanan_mermi = 0;
    
    private BufferedImage image;
    
    private ArrayList<Ates> atesler = new ArrayList<Ates>();
    private int atesdirY = 1;
    private int topX = 0;
    private int topdirX=2;
    private int uzayGemisiX = 0;
    private int dirUzayX = 20;

    public Game() throws IOException {
         image = ImageIO.read(new FileImageInputStream(new File("rocket.png")));
         setBackground(Color.BLACK);
         
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        g.fillOval(topX, 0, 20, 20);
        g.drawImage(image, uzayGemisiX, 490,image.getWidth(),image.getHeight(),this);
        timer.start();
        
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int c = e.getKeyCode();
        
        if (c == KeyEvent.VK_LEFT){
        if (uzayGemisiX<=0){
        uzayGemisiX = 0;
        }
        else {
        uzayGemisiX-=dirUzayX;
        }
        }
        
        else if (c == KeyEvent.VK_RIGHT){
            
        if (uzayGemisiX>=720){
        uzayGemisiX = 720;
        }
        else {
        uzayGemisiX+=dirUzayX;
        }
            
        
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topX += topdirX;
        
        if (topX>= 750){
        topdirX = -topdirX;       
        }
        
        if (topX<=0){
            topdirX =-topdirX;
        }
        repaint();
    }
    
    
}

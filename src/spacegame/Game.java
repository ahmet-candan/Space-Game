
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Path2D;
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
    
    public boolean kontrolEt(){
    for (Ates ates :atesler){
    if (new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(topX,0,20,20))){
        return true;
    
    }
    }
    return false;
    }

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
        
        for (Ates ates:atesler){
        if (ates.getY()<0){
        atesler.remove(ates);
        }  
    }
        g.setColor(Color.YELLOW);
        
        for(Ates ates: atesler){
            
            g.fillRect(ates.getX(),ates.getY(),10,20); 
        }
        
        if (kontrolEt()){
        timer.stop();
        
        String mesaj = "Kazandınız..\nHarcanan Ateş:"+harcanan_mermi+"Geçen Süre:"+ 
        }
        
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
        
        else if (c == KeyEvent.VK_SPACE){
        atesler.add (new Ates(uzayGemisiX+15, 490));
        
        harcanan_mermi++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported "
                + "yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     
        
        for (Ates ates:atesler){
               System.out.println(ates.getY());
        ates.setY(ates.getY()- atesdirY);
        }
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

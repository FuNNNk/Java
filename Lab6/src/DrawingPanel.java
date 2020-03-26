import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel{
    final MainFrame frame;
    final static int W=800, H=600;

    BufferedImage image;
    Graphics2D graphics;

    //random parameters for drawing
    Random rand = new Random();
    int number = rand.nextInt(40);
    int red = rand.nextInt(255);
    int green = rand.nextInt(255);
    int blue = rand.nextInt(255);

    public DrawingPanel(MainFrame frame){
        this.frame=frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage(){
        image = new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W,H);
    }

    private void init(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter(){
           public void mousePressed(MouseEvent e){
               drawShape(e.getX(), e.getY());
               repaint();
           }
        });
    }

    private void drawShape(int x, int y){
        int radius = number; //generate a random number
        int sides = (int)frame.configPanel.sidesField.getValue(); //get the value from UI(ConfigPanel)
        //get the color from the configpanel, colorCombo
        Color color;
        if(frame.configPanel.colorCombo.getSelectedIndex() == 0)
            color = new Color(red,green,blue,128); //create a transparent random color
        else
            color = new Color(0,0,0);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x,y,radius,sides));
    }

    public void update(Graphics g){}

    protected void paintComponent(Graphics g){
        g.drawImage(image,0,0,this);
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel{
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons: LOAD, RESET, EXIT
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1,4));
        //add all buttons

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void save(ActionEvent e){
        try{
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test,png"));
        }catch (IOException ioe){
            System.err.println(ioe);
        }
    }

    //next buttons
    private void load(ActionEvent e){
        try{
            ImageIO.read(new File("d:/test,png"));
        }catch (IOException ioe){
            System.err.println(ioe);
        }
    }

    private void reset(ActionEvent e){
        this.frame.remove(this.frame.canvas);
        DrawingPanel drawingPanel = new DrawingPanel(this.frame);
        this.frame.add(drawingPanel,BorderLayout.CENTER);
        this.frame.pack();
    }

    private void exit(ActionEvent e){
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame(){
        super("MainFrame");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel=new ControlPanel(this);
        this.add(controlPanel,BorderLayout.NORTH);

        designPanel= new DesignPanel(this);
        this.add(designPanel, BorderLayout.CENTER);

        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
       new MainFrame();
    }
}

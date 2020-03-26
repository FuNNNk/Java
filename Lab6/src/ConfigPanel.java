import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    String colors[]={"RANDOM","BLACK"};
    JComboBox colorCombo = new JComboBox(colors);

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);

        Random rand = new Random();
        //create the colorCombo, containing the values: Random and Black
        colorCombo.setSelectedIndex(rand.nextInt(2));

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}

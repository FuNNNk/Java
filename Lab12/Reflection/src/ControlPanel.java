import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(createButton);
        createButton.addActionListener(e -> {
            JComponent component = null;
            try {
                component = createDynamicComponent(classNameField.getText());
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }catch (InstantiationException ex){
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            if(component!=null)
            {
                try{
                    setComponentText(component, textField.getText());
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                frame.designPanel.addAtRandomLocation(component);
            }
        });
    }

    private JComponent createDynamicComponent(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        JComponent jComponent = (JComponent) Class.forName(className).newInstance();
        return jComponent;
    }

    private void setComponentText(JComponent component, String text) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = component.getClass().getMethod("setText", text.getClass());
        method.invoke(component, text);
    }
}

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {
    private static final long serVersionUID = 1L;

    public SquarePanel(Color d) {this.setBackground(d);}

    public void changeColor(Color d){
        this.setBackground(d);
        this.repaint();
    }

}

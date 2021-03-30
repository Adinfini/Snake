import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Create Default Window
        Window f1 = new Window();

        //Windows Setting to be shown
        f1.setTitle("Snake");
        f1.setSize(600,400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

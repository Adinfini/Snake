import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
     private static final long serialVersionUId = -254100L;
     public static ArrayList<ArrayList<DataOfSquare>> Grid;
     public static int width = 20;
     public static int height = 20;

     public Window(){
         //Creates the arrayList that'll contain thread;
         Grid =  new ArrayList<ArrayList<DataOfSquare>>();
         ArrayList<DataOfSquare> data;

         //Creates Threads and its data and adds it to the arrayList
         for(int i=0; i<width; i++) {
             data = new ArrayList<DataOfSquare>();
             for(int j = 0; j<height; j++){
                 DataOfSquare c = new DataOfSquare(2);
                 data.add(c);
             }
             Grid.add(data);
         }

         //Setting up the layout of the panel
         getContentPane().setLayout(new GridLayout(20,20,0,0));

         //start and pauses all threads then adds every square of each thread to the panel
         for(int i = 0; i <width; i++){
             for(int j = 0; j<height; j++){
                 getContentPane().add(Grid.get(i).get(j).square);
             }
         }

         //initial position of the snake
         //TODO::
         //passing this value to the Controller
         //TODO:
         //start the game now;
         //TODO:

         //Links the Window to the KeyboardListenner
         //TODO:
     }

}

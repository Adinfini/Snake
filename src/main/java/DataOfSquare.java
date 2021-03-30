import java.awt.*;
import java.util.ArrayList;

public class DataOfSquare {

    //ArrayList that'll contain the colors
    ArrayList<Color> C = new ArrayList<>();
    int color;// 2:snake, 1:food, 0:empty
    SquarePanel square;

    public DataOfSquare(int col) {
        //Lets add the Color to the arrayList
        C.add(Color.darkGray);//0
        C.add(Color.BLUE);//1
        C.add(Color.WHITE); //2
        color = col;
        square =  new SquarePanel(C.get(color));
    }

    public void lightMeup (int c) {
        square.changeColor(C.get(c));
    }
}

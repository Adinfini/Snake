import java.util.ArrayList;

public class ThreadsController extends Thread {
    ArrayList<ArrayList<DataOfSquare>> Squares= new ArrayList<ArrayList<DataOfSquare>>();
    Tupel headSnakePos;
    int sizeSnake = 3;
    long speed = 50;
    public static int directionSnake;

    //all the positions of Tupel
    ArrayList<Tupel> positions = new ArrayList<>();

    //food that is for the Snake
    Tupel foodPosition;

    //
    ThreadsController(Tupel positionDepart) {
        //Get all the threads
        Squares = Window.Grid;

        headSnakePos = new Tupel(positionDepart.getx(),positionDepart.getY());

        directionSnake = 1;
        //Pointer
        Tupel headPos = new Tupel(headSnakePos.getx(),headSnakePos.getY());
        positions.add(headPos);

        foodPosition = new Tupel(Window.height-1, Window.width-1);

        //spawnFood(headSnakePos);
        spawnFood(foodPosition);
    }

    private void spawnFood(Tupel foodPosition) {
        Squares.get(foodPosition.getx()).get(foodPosition.getY()).lightMeup(1);
    }

    //Important part:this controlls the moving and extension of
    //Snake
    public void run() {
        while(true){
            moveInterne(directionSnake);

        }
    }

    //Moves the head the snake and refreshes the positions in the ararylist
    //1:right, 2:left, 3:top , 4:boot 0:nothing
    private void moveInterne(int directionSnake) {
        switch (directionSnake) {
            case 4:
                headSnakePos.ChangeData(headSnakePos.getx(),(headSnakePos.getY()+1)%20);
                positions.add(new Tupel(headSnakePos.getx(), headSnakePos.getY()));
                System.out.printf("Hallo!!!");
                break;
            case 3:
                if(headSnakePos.getY()-1<0){
                    headSnakePos.ChangeData(headSnakePos.getx(), 19);
                }else {
                    headSnakePos.ChangeData(headSnakePos.getx(), Math.abs(headSnakePos.getY()-1)%20);
                }
                positions.add(new Tupel(headSnakePos.getx(), headSnakePos.getY()));
                break;
            case 2:
                if(headSnakePos.getx()-1<0){
                    headSnakePos.ChangeData(19, headSnakePos.getY());
                }else {
                    headSnakePos.ChangeData(Math.abs(headSnakePos.getx() - 1) % 20, headSnakePos.getY());
                }
                positions.add(new Tupel(headSnakePos.getx(), headSnakePos.getY()));
                break;

            case 1:
                headSnakePos.ChangeData(Math.abs(headSnakePos.getx()+1)%20,headSnakePos.getY());
                positions.add(new Tupel(headSnakePos.getx(), headSnakePos.getY()));
                break;
        }

    }


}

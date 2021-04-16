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
            checkCollision();
            moveExterne();
            deleteTail();


        }
    }

    //Refreshes the tail of the Snake, by removing the superfluous data in positions arrayList
    //and refreshing the display of the things that is removed
    private void deleteTail() {
        int cmpt = sizeSnake;
        for(int i = positions.size()-1; i>=0;i--) {
            if (cmpt == 0) {
                Tupel t = positions.get(i);
                Squares.get(t.getY()).get(t.getx()).lightMeup(2);
            } else {
                cmpt--;
            }
        }

        cmpt = sizeSnake;
        for(int i = positions.size()-1; i>=0;i--){
            if(cmpt==0){
                positions.remove(i);
            }else {
                cmpt--;
            }
        }
    }

    //Refreshes the squares that needs to appear on the Frame
    private void moveExterne() {
        for(Tupel t : positions) {
            int y = t.getx();
            int x = t.getY();
            Squares.get(x).get(y).lightMeup(0);
        }
    }

    //Checks if the Snake bites itself or is eating the food
    private void checkCollision() {
        Tupel postCritique = positions.get(positions.size()-1);
        for(int i = 0; i<=positions.size()-2;i++){
            boolean biteItSelf = postCritique.getx() == positions.get(i).getx() && postCritique.getY() ==positions.get(i).getY();
            if(biteItSelf){
                stopTheGame();
            }
        }

        boolean eatingFood = postCritique.getx() == foodPosition.getx() && postCritique.getY() == foodPosition.getY();
        if(eatingFood) {
            System.out.printf("Yummy!!!");
            sizeSnake = sizeSnake+1;
            foodPosition = getValueNotInSnake();
            spawnFood(foodPosition);
        }
    }

    //return a position not occupied by the Snake
    private Tupel getValueNotInSnake() {
        Tupel p;
        int ranX = 0 + (int)(Math.random()*19);
        int ranY = 0 + (int)(Math.random()*19);

        p = new Tupel(ranX,ranY);

        for(int i = 0; i<=positions.size()-1; i++) {
            if(p.getx()==positions.get(i).getx() && p.getY()==positions.get(i).getY()){
                ranX = 0 + (int)(Math.random()*19);
                ranY = 0 + (int)(Math.random()*19);
                i=0;
            }
        }
        return p;
    }

    //stops the Game
    private void stopTheGame() {
        System.out.printf("Collision \n");
        while(true){
            pauser();
        }
    }

    //delay between each move of the Snake
    private void pauser() {
        try {
            sleep(speed);
        }catch (InterruptedException e) {
            e.printStackTrace();
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

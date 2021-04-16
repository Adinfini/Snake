import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    //1:right
    //2:left
    //3:top
    //4:bottom
    //any other key pressed will go in default
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 39:
                // -> Right
                //this will make snake go right
                //if other keys are not pressed
                if (ThreadsController.directionSnake!=2)
                    ThreadsController.directionSnake = 1;
                break;
            case 38://->top
                if(ThreadsController.directionSnake!=4)
                    ThreadsController.directionSnake=3;
                break;
            case 37://-> Left
                if(ThreadsController.directionSnake!=1)
                    ThreadsController.directionSnake=2;
                break;
            case 40: //-> Bottom
                if(ThreadsController.directionSnake!=3)
                    ThreadsController.directionSnake=4;
                break;

            default:
                break;
        }
    }
}

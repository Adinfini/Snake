public class Tupel {
    private  int x;
    private int y;
    private int xf;
    private int yf;

    public Tupel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void ChangeData(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getx() {return x;}
    public int getY(){return y;}
    public int getXf(){return xf;}
    public int getYf(){return yf;}
}

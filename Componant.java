
package mypacman;
import java.awt.Rectangle;

/**
 *
 * @author earth
 */
public class Componant {
    // instance variables
    public int index;
    public boolean[][] states;
    public static int cellSize =  20;
    public static int max = 400; //height || width = 20*20
    public static int speed = 4;
    
    public char direction;
    public int x,y;
    
    // constructor
    public Componant() {
        this.index = 0;
        this.states = new boolean[20][20];
        
        for (int i = 0; i < 20;i++)
            for (int j = 0; j < 20; j++){
                this.states[i][j] = false;
            }
    }
    
    // methods
    public void updateState(boolean[][] updateStates) {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++){
                this.states[i][j] = updateStates[i][j];
            }
    }
        
    public boolean isValid(int x, int y) {
        if(x >= cellSize && x < max && y >= cellSize && y < max && states[x/20-1][y/20-1])
            return true;
        else
            return false;
    }
    
    // pacman size
    public Rectangle getShape() {
        return new Rectangle(x, y, 20, 20);
    }
}


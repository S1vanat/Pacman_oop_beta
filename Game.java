
package mypacman;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author earth
 */
public class Game extends JFrame implements KeyListener {
    // instance variables
    private Board board;
    private Timer timer;
    private char direction;
    public static boolean flag;
    
    // constructor
    public Game() {
        super(); // calls the constructor of the superclass (JFrame)
        this.board = new Board();
        this.direction = 'U';
        this.flag = true;
        Sound player = new Sound("./src/sound/coin.wav");
        
        setSize(437, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(board, BorderLayout.CENTER);
        setTitle("Pac-Man");
        setVisible(true);
        addKeyListener(this);
        
        timer = new Timer(30, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                if(!board.title && board.lives > 0){
                    if(flag){
                        try {
                            Thread.sleep(1500);
                            flag = false;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                board.ghost1.move();
                if(board.ghost1.getShape().intersects(board.pacman.getShape()))
                {
                    board.reset();
                    Sound player = new Sound("./src/sound/hit.wav");
                    player.play();
                }
                board.ghost2.move();
                if(board.ghost2.getShape().intersects(board.pacman.getShape()))
                {
                    board.reset();
                    Sound player = new Sound("./src/sound/hit.wav");
                    player.play();
                }
                board.ghost3.move();
                if(board.ghost3.getShape().intersects(board.pacman.getShape()))
                {
                    board.reset();
                    Sound player = new Sound("./src/sound/hit.wav");
                    player.play();
                }
                board.ghost4.move();
                if(board.ghost4.getShape().intersects(board.pacman.getShape()))
                {
                    board.reset();
                    Sound player = new Sound("./src/sound/hit.wav");
                    player.play();
                }
                
                board.ghost1.updateState(board.states);
                board.ghost2.updateState(board.states);
                board.ghost3.updateState(board.states);
                board.ghost4.updateState(board.states);
                
                //pacman eat ball
                board.pacman.move(direction);
                if(board.balls[board.pacman.x/20][board.pacman.y/20]){
                board.balls[board.pacman.x/20][board.pacman.y/20]=false;
                board.score++;
                Sound player = new Sound("./src/sound/coin.wav");
                player.play();
                
                }

                board.pacman.updateState(board.states);
            
                }
            }
        });
        
        timer.start();
    }
    public static void main(String[] args) {
        new Game();
        //play music
        Sound player = new Sound("./src/sound/never-gonna-give-you-up.wav");
        player.loop();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = 'L';
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction ='R';
        else if(e.getKeyCode() == KeyEvent.VK_UP)
            direction ='U';
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            direction ='D';
//        title disappeard
        else if(e.getKeyCode() == KeyEvent.VK_ENTER)
            board.title = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

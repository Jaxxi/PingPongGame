import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    Human p1;
    public void init(){
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        p1 = new Human(1);
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        p1.draw(g);
    }

    public void update(Graphics g){
        paint(g);
    }


    public void run() {
        for (;;){

            p1.move();

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1.setwAccel(true);
        }

        else if(e.getKeyCode() == KeyEvent.VK_S){
            p1.setsAccel(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1.setwAccel(false);
        }

        else if(e.getKeyCode() == KeyEvent.VK_S){
            p1.setsAccel(false);
        }
    }
}

import java.awt.*;

public class Human implements Pad {
        double y, yVel;
        boolean wAccel, sAccel;
        final double GRAVITY = 0.94;
        int player, x;

        public Human(int player){
            wAccel = false; sAccel = false;
            y = 210; yVel = 0;
            if(player == 1)
                x = 20;
        }

    public void draw(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(x, (int)y, 20, 80);
    }


    public void move() {
        if(wAccel){
            yVel -= 2;
        }
        else if(sAccel){
            yVel += 2;
        }
        else if(!wAccel && !sAccel){
            yVel *= GRAVITY;
        }
        if(yVel >= 5)
            yVel = 5;
        else if(yVel <= -5)
            yVel = -5;

        y += yVel;
    }

    public void setwAccel(boolean input){
            wAccel = input;
    }

    public void setsAccel(boolean input){
            sAccel = input;
    }

    public int getY() {
        return (int)y;
    }
}

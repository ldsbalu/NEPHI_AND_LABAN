import java.awt.*;

public class Room implements Drawable {

    public static final int SIZE = 50;
    private Point pos;
    private Room exitEast;
    private Room exitWest;
    private Room exitNorth;
    private Room exitSouth;

    // my constructor
    public Room(int x, int y){
        pos = new Point(x,y);
        exitEast = null;
        exitWest = null;
        exitNorth= null;
        exitSouth = null;

    }


    // draws method
    public void draw(Graphics g){
//       // north
//        g.drawLine(pos.x, pos.y, pos.x+SIZE, pos.y);
//        //west
//        g.drawLine(pos.x, pos.y, pos.x, pos.y+SIZE);
//        //south
//        g.drawLine(pos.x, pos.y +SIZE, pos.x+SIZE , pos.y+SIZE);
//        //east
//        g.drawLine(pos.x+SIZE, pos.y , pos.x+SIZE , pos.y+SIZE);

        //g.drawRect(pos.x , pos.y, SIZE,SIZE);

        //g.drawOval(pos.x+15, pos.y+15,25, 25);


        if  (exitNorth == null) {
            g.drawLine(pos.x, pos.y, pos.x+SIZE, pos.y);
        } else {
            g.drawLine(pos.x, pos.y, pos.x+SIZE/2-5, pos.y);
            g.drawLine(pos.x+SIZE/2+5, pos.y, pos.x+SIZE, pos.y);
            g.drawLine(pos.x+SIZE/2+5, pos.y, pos.x+SIZE/2+5, pos.y-5);
            g.drawLine(pos.x+SIZE/2-5, pos.y, pos.x+SIZE/2-5, pos.y-5);
        }

        if  (exitSouth == null) {
            g.drawLine(pos.x, pos.y+SIZE, pos.x+SIZE, pos.y+SIZE);
        } else {
            g.drawLine(pos.x, pos.y+SIZE, pos.x+SIZE/2-5, pos.y+SIZE);
            g.drawLine(pos.x+SIZE/2+5, pos.y+SIZE, pos.x+SIZE, pos.y+SIZE);
            g.drawLine(pos.x+SIZE/2+5, pos.y+SIZE, pos.x+SIZE/2+5, pos.y+SIZE+5);
            g.drawLine(pos.x+SIZE/2-5, pos.y+SIZE, pos.x+SIZE/2-5, pos.y+SIZE+5);
        }

        if (exitEast == null) {
            g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+SIZE);
        } else {
            g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+SIZE/2-5);
            g.drawLine(pos.x+SIZE, pos.y+SIZE/2+5, pos.x+SIZE, pos.y+SIZE);
            g.drawLine(pos.x+SIZE, pos.y+SIZE/2+5, pos.x+SIZE+5, pos.y+SIZE/2+5);
            g.drawLine(pos.x+SIZE, pos.y+SIZE/2-5, pos.x+SIZE+5, pos.y+SIZE/2-5);
        }

        if (exitWest == null) {
            g.drawLine(pos.x, pos.y, pos.x, pos.y+SIZE);
        } else {
            g.drawLine(pos.x, pos.y, pos.x, pos.y+SIZE/2-5);
            g.drawLine(pos.x, pos.y+SIZE/2+5, pos.x, pos.y+SIZE);
            g.drawLine(pos.x, pos.y+SIZE/2+5, pos.x-5, pos.y+SIZE/2+5);
            g.drawLine(pos.x, pos.y+SIZE/2-5, pos.x-5, pos.y+SIZE/2-5);
        }







    }

    public void setEastExit(Room r){
        exitEast = r;
        r.exitWest = this;

    }
    public void setNorthExit(Room r) {
        exitNorth = r;
        r.exitSouth = this;

    }
    public void setWestExit(Room r) {
        exitWest = r;
        r.exitEast = this;

    }
    public void setSouthExit(Room r){
        exitSouth = r;
        r.exitNorth = this;

    }


    public Point getPosition(){
        return pos;
    }

    public boolean hasNorthExit(){
        if (exitNorth == null){
            return false;
        }else {
            return true;
        }

    }

    public boolean hasSouthExit(){
        if (exitSouth == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean hasEastExit(){
        if (exitEast == null){
            return false;
        }else {
            return true;
        }
    }


    public boolean hasWestExit(){
        if (exitWest == null){
            return false;
        }else {
            return true;
        }
    }

    public Room getNorthExit(){
        return exitNorth;
    }

    public Room getSouthExit() {
        return exitSouth;
    }
    public Room getEastExit() {
        return exitEast;
    }
    public Room getWestExit() {
        return exitWest;
    }












}
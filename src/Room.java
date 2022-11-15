import java.awt.*;

public class Room {
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
//        g.drawLine(pos.x, pos.y, pos.x+50, pos.y);
//        //west
//        g.drawLine(pos.x, pos.y, pos.x, pos.y+50);
//        //south
//        g.drawLine(pos.x, pos.y +50, pos.x+50 , pos.y+50);
//        //east
//        g.drawLine(pos.x+50, pos.y , pos.x+50 , pos.y+50);

        //g.drawRect(pos.x , pos.y, 50,50);

        //g.drawOval(pos.x+15, pos.y+15,25, 25);


        if  (exitNorth == null) {
            g.drawLine(pos.x, pos.y, pos.x+50, pos.y);
        } else {
            g.drawLine(pos.x, pos.y, pos.x+50/2-5, pos.y);
            g.drawLine(pos.x+50/2+5, pos.y, pos.x+50, pos.y);
            g.drawLine(pos.x+50/2+5, pos.y, pos.x+50/2+5, pos.y-5);
            g.drawLine(pos.x+50/2-5, pos.y, pos.x+50/2-5, pos.y-5);
        }

        if  (exitSouth == null) {
            g.drawLine(pos.x, pos.y+50, pos.x+50, pos.y+50);
        } else {
            g.drawLine(pos.x, pos.y+50, pos.x+50/2-5, pos.y+50);
            g.drawLine(pos.x+50/2+5, pos.y+50, pos.x+50, pos.y+50);
            g.drawLine(pos.x+50/2+5, pos.y+50, pos.x+50/2+5, pos.y+50+5);
            g.drawLine(pos.x+50/2-5, pos.y+50, pos.x+50/2-5, pos.y+50+5);
        }

        if (exitEast == null) {
            g.drawLine(pos.x+50, pos.y, pos.x+50, pos.y+50);
        } else {
            g.drawLine(pos.x+50, pos.y, pos.x+50, pos.y+50/2-5);
            g.drawLine(pos.x+50, pos.y+50/2+5, pos.x+50, pos.y+50);
            g.drawLine(pos.x+50, pos.y+50/2+5, pos.x+50+5, pos.y+50/2+5);
            g.drawLine(pos.x+50, pos.y+50/2-5, pos.x+50+5, pos.y+50/2-5);
        }

        if (exitWest == null) {
            g.drawLine(pos.x, pos.y, pos.x, pos.y+50);
        } else {
            g.drawLine(pos.x, pos.y, pos.x, pos.y+50/2-5);
            g.drawLine(pos.x, pos.y+50/2+5, pos.x, pos.y+50);
            g.drawLine(pos.x, pos.y+50/2+5, pos.x-5, pos.y+50/2+5);
            g.drawLine(pos.x, pos.y+50/2-5, pos.x-5, pos.y+50/2-5);
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
















}
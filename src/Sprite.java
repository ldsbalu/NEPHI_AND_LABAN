import javax.swing.*;
import java.awt.*;

abstract class Sprite {
    protected Room currentRoom;
    protected ImageIcon image;
    public Sprite(){
        currentRoom= null;
        image = null;

    }
    public void setCurrentRoom(Room r){
        currentRoom = r;

    }
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void draw(Graphics g){
        if (currentRoom != null){
            // this method is responsible for drawing the image inside the perimeter of the Sprite's currentRoom.
            //  The image should be centered inside the room.
            Point p = currentRoom.getPosition();
            image.paintIcon(null, g, p.x+5 , p.y+7);

        }

    }

    public void moveSouth() {
       if(currentRoom.hasSouthExit()) {
           currentRoom=currentRoom.getSouthExit();
       }
    }

    public void moveNorth() {
        if(currentRoom.hasNorthExit()) {
            currentRoom=currentRoom.getNorthExit();
        }
    }
    public void moveEast(){
        if(currentRoom.hasEastExit()) {
            currentRoom=currentRoom.getEastExit();
        }
    }
    public void moveWest(){
        if(currentRoom.hasWestExit()) {
            currentRoom=currentRoom.getWestExit();
        }
    }

}

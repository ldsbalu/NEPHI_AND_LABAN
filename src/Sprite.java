import javax.swing.*;
import java.awt.*;

public class Sprite {
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

}

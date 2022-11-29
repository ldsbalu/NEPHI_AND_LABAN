import javax.swing.*;

public class Nephi extends Sprite{
    private boolean hasSword;
    private ImageIcon normalIcon;
    private ImageIcon armedIcon;


    public Nephi(){
        super();
        image = new ImageIcon("nephi.png");
        normalIcon= new ImageIcon("nephi.png");
        armedIcon =new ImageIcon("nephi_and_sword.png");

        image = normalIcon;
        hasSword = false;

    }
    public void pickUpSword()  {
        hasSword = true;
        image = armedIcon;




    }//This should set hasSword to true and set image = armedIcon.
    public boolean isArmed(){
        return hasSword;
    }   //Returns the value of hasSword.
    public void reset(){
        image = normalIcon;
        hasSword = false;

    }
    //If you want, you could call this method from Nephi's constructor, and avoid having the same code appear twice.

}

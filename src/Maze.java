import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Maze extends JPanel implements KeyListener {
    ArrayList<Drawable>  obj;
    private ArrayList<Room> rooms;
    Nephi nephi;
    Laban laban;
    Plates plates;
    Sword sword;
    Room r1, r2, r3, r4,r5,r6,r7,r8,r9,r10, r11, r12,r13,r14,r15,r16;


    public Maze(){
        addKeyListener(this);

        nephi = new Nephi();
        laban= new Laban();
        plates =new Plates();
        sword = new Sword();
        obj = new ArrayList<>();


        rooms = new ArrayList<>();
        r1 = new Room(20, 20);
        r2 = new Room(80, 20);
        r3 = new Room(140, 20);
        r4 = new Room(200, 20);
        r5 = new Room(20, 80);
        r6 = new Room(80, 80);
        r7 = new Room(140, 80);
        r8 = new Room(200, 80);
        r9 = new Room(20, 140);
        r10 = new Room(80, 140);
        r11 = new Room(140, 140);
        r12 = new Room(200, 140);
        r13 = new Room(20, 200);
        r14 = new Room(80, 200);
        r15 = new Room(140, 200);
        r16 = new Room(200, 200);


        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);
        rooms.add(r8);
        rooms.add(r9);
        rooms.add(r10);
        rooms.add(r11);
        rooms.add(r12);
        rooms.add(r13);
        rooms.add(r14);
        rooms.add(r15);
        rooms.add(r16);

        obj.add(r1);
        obj.add(r2);
        obj.add(r3);
        obj.add(r4);
        obj.add(r5);
        obj.add(r6);
        obj.add(r7);
        obj.add(r8);
        obj.add(r9);
        obj.add(r10);
        obj.add(r11);
        obj.add(r12);
        obj.add(r13);
        obj.add(r14);
        obj.add(r15);
        obj.add(r16);
        obj.add(nephi);
        obj.add(laban);
        obj.add(sword);
        obj.add(plates);


        r2.setWestExit(r1);
        r3.setSouthExit(r7);
        r4.setWestExit(r3);
        r6.setNorthExit(r2);
        r7.setWestExit(r6);
        r8.setNorthExit(r4);
        r9.setEastExit(r10);
        r10.setEastExit(r11);
        r11.setEastExit(r12);
        r12.setSouthExit(r16);
        r12.setNorthExit(r8);
        r13.setNorthExit(r9);
        r15.setEastExit(r16);
        r16.setNorthExit(r12);
        r16.setWestExit(r15);


        nephi.setCurrentRoom(r13);
        laban.setCurrentRoom(r6);
        sword.setCurrentRoom(r15);
        plates.setCurrentRoom(r1);




    }



    public void paintComponent(Graphics g){
        requestFocusInWindow();
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.BLACK);
        g.fillRect(0,0 ,w,h);

        g.setColor(Color.YELLOW);

//        for (Room r : rooms) {
//            r.draw(g);
//        }
//
//        nephi.draw(g);
//        laban.draw(g);
//        sword.draw(g);
//        plates.draw(g);

        for (Drawable d: obj) {

            d.draw(g);

        }



    }


    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(280,300);
        window.setContentPane(new Maze());
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch( code ) {
            case KeyEvent.VK_UP:
                nephi.moveNorth();
                break;
            case KeyEvent.VK_DOWN:
                nephi.moveSouth();
                break;
            case KeyEvent.VK_LEFT:
                nephi.moveWest();
                break;
            case KeyEvent.VK_RIGHT :
                nephi.moveEast();
                break;
        }
        switch( code ) {
            case KeyEvent.VK_W:
                laban.moveNorth();
                break;
            case KeyEvent.VK_S:
                laban.moveSouth();
                break;
            case KeyEvent.VK_A:
                laban.moveWest();
                break;
            case KeyEvent.VK_D :
                laban.moveEast();
                break;
        }

        if(nephi.getCurrentRoom() == sword.getCurrentRoom() ){
            nephi.pickUpSword();
            sword.setCurrentRoom(null) ;
        }
        if(nephi.getCurrentRoom() == plates.getCurrentRoom()){
            JOptionPane.showMessageDialog(null, "Congratulations Nephi! You found the brass plates!. ", "found plates", JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
        if(nephi.getCurrentRoom() == laban.getCurrentRoom()){
            if(nephi.isArmed()) {
                laban.setCurrentRoom(null) ;
            }else{

                JOptionPane.showMessageDialog(null, "Oh no Nephi! Laban got you! Try again", "Game OVER", JOptionPane.INFORMATION_MESSAGE);
                reset();
            }
        }





    repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void reset() {
        nephi.reset();
        nephi.setCurrentRoom(r13);
        laban.setCurrentRoom(r6);
        sword.setCurrentRoom(r15);
        plates.setCurrentRoom(r1);
    }
}

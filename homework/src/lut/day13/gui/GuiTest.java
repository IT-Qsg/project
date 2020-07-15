package lut.day13.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiTest {

    public static void main(String[] args) {
        new A("First GUI");
    }
}
class A extends Frame {
    public A(String title){
        super(title);
        init();
    }
    public void init(){
        this.setLocation(500,100);
        this.setSize(500,400);
        this.setResizable(false);
        this.setBackground(Color.getHSBColor(100,100,100));
        this.setLayout(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

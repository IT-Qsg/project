package Exe.filecopy;

import javax.swing.*;
import java.awt.*;

public class FileCopy {
    public static void main(String[] args) {
        FatherFrame f = new FatherFrame("文件拷贝");
        new myPanel(f);
    }
}
class FatherFrame extends JFrame {
    public FatherFrame(String title){
        super(title);
        init();
    }

    private void init() {
        this.setBounds(400,200,500,200);
        this.setResizable(false);
        //this.setBackground(Color.cyan);//颜色无法使用
        //this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class myPanel extends JPanel{
    JFrame jf;
    public myPanel(JFrame jf){
        this.jf = jf;
        init();
    }
    public void init(){

        JLabel l1 = new JLabel("源文件:"),l2 = new JLabel("复制到:");
        JFileChooser jc = new JFileChooser();
       // this.add(jc);

        /*JTextField jf1 = new JTextField();
        JTextField jf2 = new JTextField();
        jf1.setBounds(200,40,60,20);
        jf2.setBounds(200,80,60,20);*/

        l1.setBounds(100,40,60,20);
        l2.setBounds(100,80,60,20);
        l1.setFont(new Font("宋体",1,15));
        l2.setFont(new Font("宋体",1,15));
        this.add(l1);
        this.add(l2);
        /*this.add(jf1);
        this.add(jf2);*/
        setLayout(null);
        setBounds(0,0,jf.getWidth(),jf.getHeight());
        setVisible(true);
        setBackground(Color.CYAN);
        jf.add(this);
    }
}
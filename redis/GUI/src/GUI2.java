import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname FirstGui
 * @Date 2020/7/17 12:59
 * @Copyright DFEC
 **/
public class GUI2 {
    JFrame jf  = new JFrame();
    private JPanel panel;
    private JButton j1;
    private JLabel jL;
    private JTextField jt;

    public GUI2(String tatil) {
        this.jf.setTitle(tatil);
        init(panel());
    }
    public void init(JPanel panel){
        jf.setLayout(null);
        jf.setBounds(200,100,1000,500);
        jf.setVisible(true);
        jf.add(panel);
        jf.setResizable(false);//不可改变窗体大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //制作面板
    public JPanel panel(){

        panel = new JPanel();

        panel.setBounds(0,0,1000,500);
        panel.setBackground(Color.cyan);
        panel.setLayout(null);

        j1= new JButton("下一步");
        j1.setLocation(890,400);
        j1.setSize(100,20);

        jL = new JLabel("第二个");
        jL.setLocation(100,200);
        jL.setSize(100,20);
        jL.setFont(new Font("隶属",Font.BOLD,20));

        jt = new JTextField(200);
        jt.setBounds(200,200,100,50);

        panel.add(jt);
        panel.add(j1);
        panel.add(jL);
        panel.setVisible(true);

        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new GUI3("第三个");
            }
        });
        return panel;
    }


}
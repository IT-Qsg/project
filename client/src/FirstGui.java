import Util.PropertiesUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * @author 张治鑫
 * @version 1.0 v
 * @Classname FirstGui
 * @Date 2020/7/17 14:59
 * @Copyright DFEC
 **/
public class FirstGui {
    JFrame jf  = new JFrame();
    private JPanel panel;
    private JButton j1;
    private JLabel jL;
    private JTextField jt;
    private JLabel jL1;
    private JTextField jt1;
    private JLabel jL2;
    private JTextField jt2;
    private JLabel jL3;
    private JTextField jt3;

    public FirstGui(String tatil) {
        this.jf.setTitle(tatil);
        init(panel());
    }
    public void init(JPanel panel){
        jf.setLayout(null);
        jf.setBounds(500,300,800,500);
        jf.setVisible(true);
        jf.add(panel);
        jf.setResizable(false);//不可改变窗体大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //制作面板
    public JPanel panel(){

        panel = new JPanel();

        panel.setBounds(0,0,800,500);
        panel.setBackground(Color.cyan);
        panel.setLayout(null);

        j1= new JButton("下一步");
        j1.setLocation(600,400);
        j1.setSize(100,40);

        jL = new JLabel("本地地址:");
        jL.setLocation(200,100);
        jL.setSize(100,40);
        jt = new JTextField("兰州",200);
        jt.setBounds(260,105,200,30);

        jL1 = new JLabel("远程地址:");
        jL1.setLocation(200,160);
        jL1.setSize(100,40);
        jt1 = new JTextField("西安",200);
        jt1.setBounds(260,165,200,30);

        jL2 = new JLabel("单位:");
        jL2.setLocation(200,220);
        jL2.setSize(100,40);
        jt2 = new JTextField("中川机场",200);
        jt2.setBounds(260,225,200,30);

        jL3 = new JLabel("部门:");
        jL3.setLocation(200,280);
        jL3.setSize(100,40);
        jt3 = new JTextField("观测室",200);
        jt3.setBounds(260,285,200,30);

        //将组件加入到面板
        panel.add(j1);
        panel.add(jt);
        panel.add(jL);
        panel.add(jt1);
        panel.add(jL1);
        panel.add(jt2);
        panel.add(jL2);
        panel.add(jt3);
        panel.add(jL3);
        panel.setVisible(true);

        //按钮事件
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties pro = new Properties();
                String path = PropertiesUtil.readPath(jf.getTitle());

                String jl3 = jL3.getText();
                String l3 = jl3.substring(0, jl3.length() - 1);
                String v3 = jt3.getText();
                pro.put(l3,v3);

                String jl2 = jL2.getText();
                String l2 = jl2.substring(0, jl2.length() - 1);
                String v2 = jt2.getText();
                pro.put(l2,v2);

                String jl1 = jL1.getText();
                String l1 = jl1.substring(0, jl1.length() - 1);
                String v1 = jt1.getText();
                pro.put(l1,v1);


                String localAddress = jL.getText();
                String la = localAddress.substring(0, localAddress.length() - 1);
                String addressValue = jt.getText();
                pro.put(la,addressValue);

                boolean flage = PropertiesUtil.writeProperties(path, pro);
                if(flage==true){
                jf.dispose();
                new GUI2("短信猫串口");
                }else {
                    JOptionPane.showMessageDialog(null, "请重新输入！！", "提示信息！！", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        return panel;
    }
//    public static void main(String[] args) {
//        new FirstGui("myGUI");
//    }
/*    //关闭窗体
        public  void closWin(){
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    class closWin extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent e) {
            System.exit(0);
        }
    }*/

}

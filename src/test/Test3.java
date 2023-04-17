package test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 600);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        //关闭模式
        jFrame.setLayout(null);


        JButton jtb1 = new JButton("点我呀");
        JButton jtb2 = new JButton("点我呀");
        jtb1.setBounds(0,0,100,50);
        jtb2.setBounds(100, 0, 100, 50);
//        jtb1.addActionListener(new MyActionListener());


        //匿名内部类
//        jtb1.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("按钮被点击");
//            }
//        });
        jFrame.getContentPane().add(jtb1);
        jFrame.getContentPane().add(jtb2);


        jFrame.setVisible(true);
    }
}

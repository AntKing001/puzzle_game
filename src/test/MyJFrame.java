package test;

import org.omg.CORBA.ARG_OUT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("点我呀");
    JButton jtb2 = new JButton("不要点我呀");

    public MyJFrame() {
        this.setSize(600, 600);
        this.setTitle("事件演示");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setLayout(null);


        jtb1.setBounds(0, 0, 100, 50);
        jtb1.addActionListener(this);

        jtb2.setBounds(100, 0, 100, 50);
        jtb2.addActionListener(this);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);


        this.setVisible(true);
        //匿名内部类
//        jtb1.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("按钮被点击");
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (jtb1 == source) {
            jtb1.setSize(200, 200);
        } else {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }
}
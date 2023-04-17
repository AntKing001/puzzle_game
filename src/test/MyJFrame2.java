package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    JButton jtb1 = new JButton("点我啊");

    public MyJFrame2() {
        this.setSize(500, 500);
        this.setLayout(null);
        this.setTitle("哈哈哈哈");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtb1.addMouseListener(this);
        jtb1.setBounds(0, 0, 100, 50);

        this.getContentPane().add(jtb1);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单件");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按压");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
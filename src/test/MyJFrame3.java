package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        this.setSize(600, 600);
        this.setTitle("点我吖");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        //为整个界面添加监听
        this.addKeyListener(this);



        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不送会反复调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不送");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        int code = e.getKeyCode();
        System.out.println(code);
    }
}

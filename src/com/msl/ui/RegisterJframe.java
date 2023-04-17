package com.msl.ui;

import javax.swing.*;

public class RegisterJframe extends JFrame {
    public RegisterJframe() {
        initJFrame();
        initBackground();
    }

    private void initBackground() {
        JLabel jLabel = new JLabel(new ImageIcon("image/register/register.jpg"));
        jLabel.setBounds(0, 0, 500, 500);
        this.getContentPane().add(jLabel);
    }

    private void initJFrame() {
        this.setSize(500, 500);
        this.setTitle("拼图 注册");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        this.setVisible(true);
    }
}
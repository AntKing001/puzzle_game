package com.msl.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class LoginJframe extends JFrame implements MouseListener {

    JButton user = new JButton("用户名");

    JTextField jTextFieldUser = new JTextField("");
    JButton password = new JButton("密 码");
    JPasswordField jPasswordFieldPassword = new JPasswordField("");
    JButton verificationCode = new JButton("验证码");
    JTextField jTextFieldVerificationCode = new JTextField("");
    String code = get_code();
    JTextField jTextField = new JTextField(code);
    JButton jButtonLogin = new JButton("登录");
    JButton jButtonRegister = new JButton("注册");

    public LoginJframe() {
        initJFrame();
        initLogin();
        initBackground();
        this.setVisible(true);
    }

    private void initBackground() {
        JLabel jLabel = new JLabel(new ImageIcon("image/register/register.jpg"));
        jLabel.setBounds(0, 0, 500, 500);
        this.getContentPane().add(jLabel);
    }

    private void initJFrame() {
        this.setBounds(500,300,500,500);
        this.setTitle("拼图 登录");
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initLogin() {
        int x = 100, y = 80;
        user.setBounds(x, y + 50, 80, 30);
        jTextFieldUser.setBounds(x + 80, y + 50, 150, 30);

        password.setBounds(x, y + 100, 80, 30);
        jPasswordFieldPassword.setBounds(x + 80, y + 100, 150, 30);

        verificationCode.setBounds(x, y + 150, 80, 30);
        jTextFieldVerificationCode.setBounds(x + 80, y + 150, 80, 30);


        jTextField.setBounds(x + 170, y + 150, 60, 30);
        jButtonLogin.setBounds(x + 40, y + 250, 60, 30);
        jButtonRegister.setBounds(x + 185, y + 250, 65, 30);
        jButtonLogin.addMouseListener(this);
        jButtonRegister.addMouseListener(this);

        this.getContentPane().add(user);
        this.getContentPane().add(jTextFieldUser);

        this.getContentPane().add(password);
        this.getContentPane().add(jPasswordFieldPassword);

        this.getContentPane().add(verificationCode);
        this.getContentPane().add(jTextFieldVerificationCode);
        this.getContentPane().add(jTextField);

        this.getContentPane().add(jButtonLogin);
        this.getContentPane().add(jButtonRegister);

    }

    private String get_code() {
        String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] tempArr = new char[6];
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            char temp = ch.charAt(r.nextInt(52));
            tempArr[i] = temp;
        }
        return String.valueOf(tempArr);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(jButtonLogin)) {
            if (!jTextFieldVerificationCode.getText().equalsIgnoreCase(code)) {
                showJDialog("验证码错误!");
                code = get_code();
                jTextField.setText(code);
                this.getContentPane().repaint();
                return;
            }
            if (jTextFieldUser.getText().equals("root") && String.valueOf(jPasswordFieldPassword.getPassword()).equals("123456")) {
                System.out.println("登录成功!");
                this.setVisible(false);
                new GameJframe();
            } else {
                showJDialog("用户名或密码错误!");
            }
        } else {
            this.setVisible(false);
            new RegisterJframe();
        }
    }

    private void showJDialog(String string) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 100);
        jDialog.setModal(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setAlwaysOnTop(true);
        JButton jButton = new JButton(string);
        jButton.setBounds(0,0,60,30);
        Font font = new Font("华文行楷",Font.BOLD,20);  //定义字体
        jButton.setFont(font);      //为按钮设置字体
        jDialog.getContentPane().add(jButton);
        jDialog.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
package com.msl.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener , ActionListener {
    JMenuItem replayItem = new JMenuItem("重新游戏");

    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    int data[][] = new int[3][3];
    int x, y;   //记录空白方块到位置
    String path = "image/picture/p1/";
    int[][] win = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };
    int step = 0;  //统计步数

    public GameJframe() {
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            //获取随机索引
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 3;
                y = i % 3;
            }
            data[i / 3][i % 3] = tempArr[i];
        }
    }

    private void initImage() {

        this.getContentPane().removeAll();   //清空已经加载到图片


        JLabel stepCnt = new JLabel("步数" + step);
        stepCnt.setBounds(30, 20, 100, 20);

        this.getContentPane().add(stepCnt);

        JLabel background = new JLabel(new ImageIcon("image/background.JPG"));
        background.setBounds(0, 0, 700, 750);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".png"));
                jLabel.setBounds(j * 200 + 50, i * 200 + 50, 200, 200);

                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //图片凸起效果,斜面边框
                this.getContentPane().add(jLabel);
            }
        }
        this.getContentPane().add(background);
        this.getContentPane().repaint();   //刷新界面
        if (victory()) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image/win.jpg"));
            jLabel.setBounds(25, 25, 250, 250);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(300, 300);
            jDialog.setAlwaysOnTop(true);
            jDialog.setModal(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        }

    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu abouJMenu = new JMenu("关于我们");


        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        abouJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(abouJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(700, 750);
        this.setTitle("拼图单机版v1.0");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(path + "all.png"));
            jLabel.setBounds(50, 50, 600, 600);
            JLabel background = new JLabel(new ImageIcon("image/background.JPG"));
            background.setBounds(0, 0, 1500, 1000);
            this.getContentPane().add(jLabel);
            this.getContentPane().add(background);
            this.getContentPane().repaint();   //刷新
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();          //获取键值
        if (code == 37 && y + 1 < 3) {       //向左移动
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
        }
        if (code == 38 && x + 1 < 3) {      //向上移动
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
        }
        if (code == 39 && y - 1 >= 0) {      //向右移动
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
        }
        if (code == 40 && x - 1 >= 0) {      //向下移动
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
        }
        if (code == 87) {         //一键通关
            data = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 0}
            };
        }
        initImage();    //重新加载图片
    }

    public boolean victory() {  //判断游戏是否结束
        for (int i = 0; i < 9; i++) {
            if (data[i / 3][i % 3] != win[i / 3][i % 3]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //获取点击条目到对象

        if (obj == reLoginItem) {
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJframe();
        }
        if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0); //直接关闭
        }
        if (obj == replayItem) {
            System.out.println("重新游戏");
            step = 0;
            initData();
            initImage();
        }
        if (obj == accountItem) {
            System.out.println("公众号");
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image/about.jpg"));
            jLabel.setBounds(0, 0, 724, 1086);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(400, 600);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);  //弹框不关闭无法操作其他界面
            jDialog.setVisible(true);
        }
    }
}
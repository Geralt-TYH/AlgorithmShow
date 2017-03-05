package view;

import tool.MySetting;

import javax.swing.*;
import java.awt.*;

/**
 * 程序主界面，唯一入口
 * Created by Geralt on 2017/1/29.
 */
public class FrameMain extends JFrame {
    MenuBar menuBar;
    PanelMain panelMain;

    public FrameMain(){
        menuBar=new MenuBar();
        panelMain=new PanelMain();
        this.setJMenuBar(menuBar);
        this.add(panelMain);
        this.setSize(MySetting.screenW, (int) (MySetting.screenH*0.95));
        this.setTitle("计算机操作系统教学辅助");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        FrameMain frameMain =new FrameMain();
    }

}

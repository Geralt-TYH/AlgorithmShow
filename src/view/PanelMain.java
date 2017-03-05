package view;

import tool.MyFont;
import tool.MySetting;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Geralt on 2017/1/31.
 */
public class PanelMain extends JSplitPane {
    JPanel left,right;
    JLabel show;
    CardLayout cardLayout;
    PanelShow panelShow;
    public PanelMain(){

        left=new JPanel();
        show=new JLabel("算法演示");
        show.setFont(MyFont.fontLevelOne);
        left.add(show);
        this.setLeftComponent(left);


        cardLayout=new CardLayout();
        panelShow=new PanelShow();
        right=new JPanel(cardLayout);
        right.add(panelShow,"1");

        this.setRightComponent(right);
        this.setDividerLocation((int)(MySetting.screenW*0.06));

    }
}

package view;

import tool.MyFont;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Geralt on 2017/1/29.
 */
public class MenuBar extends JMenuBar implements ActionListener{
    //文件
    JMenu File;
    //文件二级菜单
    JMenuItem New;
    JMenuItem Open;
    JMenuItem Save;
    JMenuItem Exit;
    public MenuBar(){
        File=new JMenu("文件");
        File.setFont(MyFont.fontLevelOne);
        New=new JMenuItem("新建");
        New.setFont(MyFont.fontLevelOne);
        Open=new JMenuItem("打开");
        Open.setFont(MyFont.fontLevelOne);
        Save=new JMenuItem("保存");
        Save.setFont(MyFont.fontLevelOne);
        Exit=new JMenuItem("退出");
        Exit.setFont(MyFont.fontLevelOne);
        Exit.addActionListener(this);
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Exit);
        this.add(File);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Exit){
            System.exit(0);
        }
    }
}

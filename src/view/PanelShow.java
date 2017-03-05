package view;

import model.tableModel.SourceModel;
import model.tableModel.TargetModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 将源数据和运算后的数据显示在这个面板里
 * Created by Geralt on 2017/1/31.
 */
public class PanelShow extends JPanel implements ActionListener{
    JButton btnOpen,btnNew,btnSave;
    JPanel panelBtn ,panel;
    JTable sourceTable,targetTable;
    JScrollPane scrollPane1,scrollPane2;
    SourceModel sm;
    TargetModel tm;
    JPanel pMain,pMainNoth,pMainSouth;
    JButton btnFCFS,btnSJF;

    public PanelShow(){
        //上部
        btnNew=new JButton("新建");
        btnNew.addActionListener(this);
        btnOpen=new JButton("打开");
        btnOpen.addActionListener(this);
        btnSave=new JButton("保存");
        btnSave.addActionListener(this);
        panel=new JPanel();
        panel.add(btnNew);
        panel.add(btnOpen);
        panel.add(btnSave);
        panelBtn=new JPanel(new BorderLayout());
        panelBtn.add(panel,BorderLayout.WEST);



        //中部
        //中上
        pMainNoth=new JPanel(new BorderLayout());
        JLabel lbtip1=new JLabel("源数据");
        sm=new SourceModel();
        sourceTable =new JTable(10,10);
        sourceTable.setModel(sm);
        scrollPane1 =new JScrollPane(sourceTable);
        pMainNoth.add(lbtip1,BorderLayout.NORTH);
        pMainNoth.add(scrollPane1,BorderLayout.SOUTH);
        //中下
        pMainSouth=new JPanel(new BorderLayout());
        JPanel temp=new JPanel();
        btnFCFS =new JButton("FCFS");
        btnFCFS.addActionListener(this);
        btnSJF=new JButton("SJF");
        btnSJF.addActionListener(this);
        JLabel lbtip2=new JLabel("运算结果");
        temp.add(lbtip2);
        temp.add(btnFCFS);
        temp.add(btnSJF);

        tm=new TargetModel();
        targetTable=new JTable();
        targetTable.setModel(tm);
        scrollPane2=new JScrollPane(targetTable);
        pMainSouth.add(temp,BorderLayout.NORTH);
        pMainSouth.add(scrollPane2,BorderLayout.SOUTH);

        pMain=new JPanel(new BorderLayout());
        pMain.add(pMainNoth,BorderLayout.NORTH);
        pMain.add(pMainSouth,BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(pMain);
        this.add(panelBtn,BorderLayout.NORTH);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnOpen){
            JFileChooser jfc=new JFileChooser();
            jfc.setDialogTitle("选择文件");
            jfc.showOpenDialog(null);
            jfc.setVisible(true);
            String filePath=jfc.getSelectedFile().getAbsolutePath();
            sm=new SourceModel();
            sm.readProcesses(filePath);
            sourceTable.setModel(sm);
        }
        if (e.getSource()== btnFCFS){
            tm=new TargetModel();
            tm.executeFCFS(sm.getProcesses());
            targetTable.setModel(tm);
        }
        if (e.getSource()== btnSJF){
            tm=new TargetModel();
            tm.executeSJF(sm.getProcesses());
            targetTable.setModel(tm);
        }
    }
}

package model.tableModel;

import model.MyProcess;
import tool.Alogorithm;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Geralt on 2017/2/2.
 */
public class TargetModel extends AbstractTableModel {
    Vector<MyProcess> processes =null;
    Vector<String> title=null;
    Scanner scanner = null;
    public TargetModel(){
        processes =new Vector<MyProcess>();
        title=new Vector<String>();
        title.add("进程ID");
        title.add("到达时间");
        title.add("服务时间");
        title.add("开始时间");
        title.add("完成时间");
        title.add("周转时间");
        title.add("带权周转时间");
    }
    public void executeFCFS(Vector<MyProcess> processes){
        this.processes= Alogorithm.FCFS(processes);
    }
    public void executeSJF(Vector<MyProcess> processes){
        this.processes= Alogorithm.SJF(processes);
    }


    @Override
    public int getRowCount() {
        return processes.size();
    }

    @Override
    public String getColumnName(int column) {
        return title.get(column);
    }

    @Override
    public int getColumnCount() {
        return title.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.processes.get(rowIndex).get(columnIndex);
    }
}

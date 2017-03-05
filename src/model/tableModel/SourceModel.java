package model.tableModel;

import model.MyProcess;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Geralt on 2017/1/29.
 */
public class SourceModel extends AbstractTableModel {
    Vector<MyProcess> processes=null;

    public Vector<MyProcess> getProcesses() {
        return processes;
    }

    Vector<String> title=null;
    Scanner scanner = null;
    public SourceModel(){
        title=new Vector<String>();
        processes = new Vector<MyProcess>();
        title.add("进程ID");
        title.add("到达时间");
        title.add("服务时间");
    }
    public void readProcesses(String filePath){
            try {
                scanner = new Scanner(new File(filePath));
                while (scanner.hasNext()) {
//                    Vector<String> row=new Vector<String>();
                    MyProcess row=new MyProcess();
                    String processID=scanner.next();
                    String arrivalTime=scanner.next();
                    String serviceTime=scanner.next();
//                    row.add(processID);//processID
//                    row.add(arrivalTime);//arrivalTime
//                    row.add(serviceTime);//serviceTime
                    row.setProcessID(processID);
                    row.setArrivalTime(Integer.valueOf(arrivalTime));
                    row.setServiceTime(Integer.valueOf(serviceTime));
                    processes.add(row);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    @Override
    public int getRowCount() {
        return processes.size();
    }

    @Override
    public int getColumnCount() {
        return title.size();
    }

    @Override
    public String getColumnName(int column) {
        return title.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return processes.get(rowIndex).get(columnIndex);
    }
}

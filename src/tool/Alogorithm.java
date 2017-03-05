package tool;

import model.MyProcess;

import java.util.Comparator;
import java.util.Vector;

/**
 * Created by Geralt on 2017/3/5.
 */
public class Alogorithm {
    /**
     * 先进先服务算法
     * @param processes
     * @return
     */
    public static Vector<MyProcess> FCFS(Vector<MyProcess> processes){
        sortByArrivalTime(processes);
        int currentTime = 0;
        for (int i = 0; i < processes.size(); i++) {
//            System.out.println("时刻"+currentTime+": 进程"+processes.get(i).getProcessID()+"启动");
            if(processes.get(i).getArrivalTime()>=currentTime){
                processes.get(i).setStartingTime(processes.get(i).getArrivalTime());
                processes.get(i).setFinishingTime(processes.get(i).getStartingTime()+processes.get(i).getServiceTime());
                processes.get(i).setTurnAroundTime(processes.get(i).getFinishingTime()-processes.get(i).getArrivalTime());
                processes.get(i).setAverageTAT((double)processes.get(i).getTurnAroundTime() / processes.get(i).getServiceTime());
            }else {
                processes.get(i).setStartingTime(currentTime);
                processes.get(i).setFinishingTime(processes.get(i).getStartingTime()+processes.get(i).getServiceTime());
                processes.get(i).setTurnAroundTime(processes.get(i).getFinishingTime()-processes.get(i).getArrivalTime());
                processes.get(i).setAverageTAT((double)processes.get(i).getTurnAroundTime() / processes.get(i).getServiceTime());
            }
            currentTime = processes.get(i).getFinishingTime();
        }
        return processes;
//        ProcessUtil.sortByID(processes);
    }

    /**
     * 最短作业优先算法
     * @param processes
     * @return
     */
    public static Vector<MyProcess> SJF(Vector<MyProcess> processes){
        sortByServiceTime(processes);
        int currentTime = 0; //起始时刻
        int next;
        while((next=nextVisit(currentTime,processes))!=-1){
             processes.get(next).setStartingTime(currentTime);
             processes.get(next).setFinishingTime(processes.get(next).getServiceTime()+processes.get(next).getStartingTime());
             processes.get(next).setTurnAroundTime(processes.get(next).getFinishingTime()-processes.get(next).getArrivalTime());
             processes.get(next).setAverageTAT((double)processes.get(next).getTurnAroundTime() / processes.get(next).getServiceTime());
             currentTime = processes.get(next).getFinishingTime();
             }
             return processes;
    }

    public static void sortByArrivalTime(Vector<MyProcess> processes){
        processes.sort(new Comparator<MyProcess>() {
            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                if(o1.getArrivalTime()>o2.getArrivalTime()){
                    return 1;
                }else if (o1.getArrivalTime()==o2.getArrivalTime()){
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
    public static void sortByServiceTime(Vector<MyProcess> processes) {
        processes.sort(new Comparator<MyProcess>(){

            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                if (o1.getServiceTime() > o2.getServiceTime()) {
                    return 1;
                } else if (o1.getServiceTime() == o2.getServiceTime()) {
                    return 0;
                } else {
                    return -1;
                }
            }

        });
    }
    private static int nextVisit(int currentTime,Vector<MyProcess> processes) {
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).isVisited() == false && processes.get(i).getArrivalTime() < currentTime) {
                processes.get(i).setVisited(true);
                return i;
            }
        }
        return findFirstArrival(processes); //先到达先执行;
    }
    public static int findFirstArrival(Vector<MyProcess> processes) {
        int firstArrival = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).isVisited() == false
                    && processes.get(i).getArrivalTime() < firstArrival) {
                firstArrival = processes.get(i).getArrivalTime();
                index = i;
            }
        }
        if (index != -1)
            processes.get(index).setVisited(true); // index值改变代表进程被找到，设置进程visited值
        return index;
    }
}

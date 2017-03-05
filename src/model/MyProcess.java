package model;

/**
 * Created by Geralt on 2017/2/1.
 */
public class MyProcess {
    private String processID;
    private int arrivalTime;   //到达时间
    private int serviceTime;   //服务时间
    private int startingTime; //开始时间
    private int finishingTime; //完成时间
    private int turnAroundTime; //周转时间
    private double averageTAT;  //带权周转时间
    private boolean visited = false;

    public MyProcess(){

    }
    public MyProcess(String processID, int arrivalTime, int serviceTime) {
        super();
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    public Object get(int i){
        Object targat=null;
        if (i==0){
            targat=processID;
        }
        if (i==1){
            targat= arrivalTime;
        }
        if (i==2){
            targat= serviceTime;
        }
        if (i==3){
            targat= startingTime;
        }
        if (i==4){
            targat= finishingTime;
        }
        if (i==5){
            targat= turnAroundTime;
        }
        if (i==6){
            targat= averageTAT;
        }
        return targat;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(int startingTime) {
        this.startingTime = startingTime;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public double getAverageTAT() {
        return averageTAT;
    }

    public void setAverageTAT(double averageTAT) {
        this.averageTAT = averageTAT;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

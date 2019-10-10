

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Task
{
    //representation of each task
    private String name;
    private int pid;
    private int arrival;
    private int priority;
    private int burst;
    //
    private static AtomicInteger pidAllocator = new AtomicInteger();

    public Task(String name, int arrival, int priority, int burst){
        this.name = name;
        this.arrival = arrival;
        this.priority = priority;
        this.burst = burst;
        this.pid = pidAllocator.getAndIncrement();
    }

    /***************
     ****GETTERS****
     ***************/
    public String getName(){
        return name;
    }

    public int getPid(){
        return pid;
    }

    public int getArrival(){
        return arrival;
    }

    public int getPriority(){
        return priority;
    }

    public int getBurst(){
        return burst;
    }

    /****************
     ****SETTERS*****
     ****************/
    public int setArrival(int arrival){
        this.arrival = arrival;
        return arrival;
    }

    public int setPriority(int priority){
        this.priority = priority;
        return priority;
    }

    public int setBurst(int burst){
        this.burst = burst;
        return burst;
    }


    public boolean equals(Object other){
        if(other == this)
            return true;

        if(!(other instanceof Task))
            return false;

        Task rhs = (Task)other;
        return (this.pid == rhs.pid) ? true : false;
    }


    public static Comparator<Task> burstSort = (o1, o2) -> {
        int burst1 = o1.getBurst();
        int burst2 = o2.getBurst();
        return burst1 - burst2;
    };

    public static Comparator<Task> arrivalSort = (o1, o2) -> {
	int arrival1 = o1.getArrival();
	int arrival2 = o2.getArrival();
	if(arrival1 == arrival2){
	    o1
    }
	return arrival1 - arrival2;

    public static Comparator<Task> arrival2burstSort = (o1, o2) -> {
        int arrival1 = o1.getArrival();
        int arrival2 = o2.getArrival();
        int burst1 = o1.getBurst();
        int burst2 = o2.getBurst();
        if(arrival1 == arrival2){
            return burst1 -burst2;
        }
        return arrival1 - arrival2;
    };

    public static Comparator<Task> arrival2prioritySort = (o1, o2) -> {
        int arrival1 = o1.getArrival();
        int arrival2 = o2.getArrival();
        int priority1 = o1.getPriority();
        int priority2 = o2.getPriority();
        if(arrival1 == arrival2){
            return (priority2 - priority1);
        }
        return arrival1 - arrival2;
    };

    public static Comparator<Task> prioritySort = (o1, o2) -> {
        int priority1 = o1.getPriority();
        int priority2 = o2.getPriority();
        return priority2 - priority1;
    };

    public String toString(){
        return "PID: <"+name+"> \t" + "Arrival: <"+ arrival +"> \t" + "Priority: <"+priority+"> \t"+ "Burst: <"+burst+"> ";
    }

    public String final2String(int time){
        return "\tAt time < " + time + "ms >, the CPU starts running process < " + name +" >,";
    }
}



import java.util.Collections;
import java.util.List;

public class RR implements Algorithm {
    private final List<Task> queue;


    public RR(List<Task> queue){
        this.queue = queue;
    }


    @Override
    public void schedule() {
        Collections.sort(queue,Task.arrivalSort);
        System.out.println("|***************************************************************|");
        System.out.println("|*******************  ITEMS IN RR SORT  ************************|");
        System.out.println("|***************************************************************|");
        for( int i = 0; i< queue.size(); i++){
            System.out.println(" \t" + queue.get(i));
        }
        System.out.println("|***************************************************************|");
        pickNextTask();
    }

    @Override
    public Task pickNextTask() {
        int startTime = 0;

        for (int i = 0; i < queue.size() ; i++) {
            if(queue.get(i).getBurst() > 10){
                Task temp = queue.get(i);
                temp.setBurst(queue.get(i).getBurst() - 10);
                System.out.println(queue.get(i).final2String(startTime));
                startTime += 10;
                temp.setArrival(startTime);
                queue.remove(i);
                queue.add(temp);
                i--;
            }
            else{
                System.out.println(queue.get(i).final2String(startTime));
                startTime += queue.get(i).getBurst();
                queue.remove(i);
                i--;
            }
        }
        System.out.println("|***************************************************************|");
        System.out.println("|*** End of results for < Round-Robin > Scheduling Algorithm ***|");
        System.out.println("|***************************************************************|");
        return null;
    }
}

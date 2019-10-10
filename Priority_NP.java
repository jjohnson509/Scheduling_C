

import java.util.Collections;
import java.util.List;

public class Priority_NP implements Algorithm {
    private final List<Task> queue;

    public Priority_NP(List<Task> queue){
        this.queue = queue;
    }


    @Override
    public void schedule() {
        Collections.sort(queue,Task.arrival2prioritySort);
        System.out.println("|***************************************************************|");
        System.out.println("|******************  ITEMS IN PRIORITY SORT  *******************|");
        System.out.println("|***************************************************************|");
        for( int i = 0; i< queue.size(); i++){
            System.out.println(queue.get(i) );
        }
        System.out.println("|***************************************************************|");
        System.out.println("|********  Results for < Priority > Scheduling Algorithm *******|");
	System.out.println("|***************************************************************|");
        pickNextTask();
    }

    @Override
    public Task pickNextTask() {
        Task nextTask;
        int startTime = 0;
        for(int i = 0; i < queue.size(); i++){
            nextTask = queue.get(i);
            System.out.println(nextTask.final2String(startTime));
            startTime += queue.get(i).getBurst();
        }
        System.out.println("|***************************************************************|");
        System.out.println("|**** End of results for < Priority > Scheduling Algorithm *****|");
        System.out.println("|***************************************************************|\n\n");
        return null;
    }
}

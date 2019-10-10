

import java.util.Collections;
import java.util.List;

public class SJF_NP implements Algorithm{

    private final List<Task> queue;


    public SJF_NP(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        Collections.sort(queue, Task.arrival2burstSort);
        System.out.println("|***************************************************************|");
        System.out.println("|*******************  ITEMS IN BURST SORT  *********************|");
        System.out.println("|***************************************************************|");


        for (int i = 0; i < queue.size(); i++){
            System.out.println(queue.get(i));
        }
        System.out.println("|***************************************************************|");
        System.out.println("|**********  Results for < SJF > Scheduling Algorithm **********|");
	System.out.println("|***************************************************************|");
        pickNextTask();

    }

    @Override
    public Task pickNextTask() {
        Task nextTask;
        int startTime = 0;
        for (int i = 0; i < queue.size(); i++){
            nextTask = queue.get(i);
            System.out.println(nextTask.final2String(startTime));
            startTime += queue.get(i).getBurst();
        }
        System.out.println("|***************************************************************|");
        System.out.println("|****** End of results for <  SJF  > Scheduling Algorithm ******|");
        System.out.println("|***************************************************************|\n\n\n");
        return null;
    }
}

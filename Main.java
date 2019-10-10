

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	    if (args.length != 1){
	        System.err.println("USAGE: java Main <process_schedule_name>.txt");
	        System.exit(0);
        }

	    BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

        String schedule;

        List<Task> queue = new ArrayList<>();

        while( (schedule = inFile.readLine()) != null){
            String[] params = schedule.split(",\\s*");
            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3])));
    }

        inFile.close();
        System.out.println("|**************************************************************|");
        System.out.println("|****************** ITEMS IN DATA STRUCTURE *******************|");
        System.out.println("|**************************************************************|");

        for (int i = 0; i < queue.size(); i++){
            System.out.println(queue.get(i) );
        }
        System.out.println("|**************************************************************|");
        System.out.println("|                                                              |\n\n\n\n");

        Algorithm scheduler = new SJF_NP(queue);
        Algorithm scheduler1 = new Priority_NP(queue);
        Algorithm scheduler2 = new RR(queue);
        scheduler.schedule();
        scheduler1.schedule();
        scheduler2.schedule();




    }
}

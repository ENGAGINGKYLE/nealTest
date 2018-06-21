package ThreadPool;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<?>> taskResults = new LinkedList<>();

        for(int i=1; i<=10; i++){
            taskResults.add(executorService.submit(new CodingTask(i)));
    }

        System.out.println("10 tasks dispatched successfully...");

//        for(Future<?> taskResult :taskResults){
//            taskResult.get();
//        }

        System.out.println("All tasks finished...");
        executorService.shutdown();
    }

}

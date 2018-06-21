package ThreadPool;

public class CodingTask implements Runnable {

    private int employeeId;

    public CodingTask(int employeeId){
        this.employeeId = employeeId;
    }

    @Override
    public void run() {
        System.out.println("Employee" + employeeId + " is coding...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Employee" + employeeId + " finshed...");
    }
}

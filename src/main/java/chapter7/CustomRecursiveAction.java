package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {

    private String workload = "";//represents load
    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() < THRESHOLD) {
            ForkJoinTask.invokeAll(splitStringToSmallerTask());
        } else {
            processing(workload);
        }
    }

    private List<CustomRecursiveAction> splitStringToSmallerTask() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
        return subtasks;
    }

    private void processing(String work) {
        System.out.println(Thread.currentThread().getName());
        String result = work.toUpperCase();
        System.out.println("This result - (" + result + ") - was processed by "
                + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("hellouw to all");
        customRecursiveAction.fork();

    }
}

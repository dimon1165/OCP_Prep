package chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CyclicBarrier - takes limit of tasks in constructor and when one of task finishes call await on it.
// CyclicBarrier waits until await will be equal to limit of tasks sent to its constructor.
public class LionPenManager {
    private void removeAnimal() throws InterruptedException {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2) {
        try {
            removeAnimal();
            cyclicBarrier1.await();
            cleanPen();
            cyclicBarrier2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager lionPenManager = new LionPenManager();
            CyclicBarrier cyclicBarrier1 = new CyclicBarrier(4);
            CyclicBarrier cyclicBarrier2 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!"));
            for (int i = 0; i < 4; i++) {
                service.submit(() -> lionPenManager.performTask(cyclicBarrier1, cyclicBarrier2));
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}

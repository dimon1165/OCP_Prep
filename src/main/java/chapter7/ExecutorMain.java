package chapter7;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.*;

// Submit task:
// execute(Runnable); - for non-return value tasks
// <?>submit(Runnable); <T>Feature<T>submit(Callable<T>) -> returns Feature
// <T>List<Future<T>>invokeAll(Collection<Callable<? extends T>>) - executes synchronously all tasks form collection
// returns in the same order Features as submitted.
// <T> T invokeAny(Collection<Callable<? extends T>>) - executes synchronously all tasks form given collection and
// returns result on one.
public class ExecutorMain {
    public static void main(String[] args) throws InterruptedException {
        //Concurrent collections
        Queue<Integer> i1 = new ConcurrentLinkedQueue<>();
        i1.offer(31);
        System.out.println(i1.peek());
        System.out.println(i1.poll());

        Deque<Integer> integers = new ConcurrentLinkedDeque<>();
        integers.offer(10);// add element to queue
        integers.push(4);// push element at first place (head of queue)
        System.out.println(integers.peek()); // get next element
        System.out.println(integers.poll()); // get and delete next element

        BlockingQueue<Integer> queue = new LinkedTransferQueue<>();
        queue.offer(10, 1000, TimeUnit.MILLISECONDS); // waits 1s and for available place in queue
        System.out.println(queue);

        //ConcurrentSkipList, ConcurrentSkipSet, ConcurrentSkipMap - concurrent versions of Set and Map
    }
}

package ru.vtb.t1.course.homework3;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPoolExecutor {

    private final LinkedList<Runnable> workQueue;
    private final Object monitor = new Object();
    private final AtomicBoolean isShutdown = new AtomicBoolean();

    public CustomThreadPoolExecutor(int corePoolSize) {
        this.workQueue = new LinkedList<>();
        for (int i = 0; i < corePoolSize; i++) {
            new Thread(() -> {
                synchronized (monitor) {
                    while (workQueue.isEmpty()) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                while (!isEmptyWork()) {
                    getAndRemoveFirstWork().run();
                }
                Thread.currentThread().interrupt();
            }).start();
        }
    }

    public void execute(Runnable command) {
        synchronized (monitor) {
            if (isShutdown.get()) {
                throw new IllegalStateException();
            }
            workQueue.add(command);
            monitor.notifyAll();
        }
    }

    public void shutdown() {
        synchronized (monitor) {
            isShutdown.set(true);
        }
    }

    private boolean isEmptyWork() {
        synchronized (monitor) {
            return workQueue.isEmpty();
        }
    }

    private Runnable getAndRemoveFirstWork() {
        synchronized (monitor) {
            return workQueue.removeFirst();
        }
    }

}

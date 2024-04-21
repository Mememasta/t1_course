package ru.vtb.t1.course.homework3;

public class Application {

    public static void main(String[] args) {
        CustomThreadPoolExecutor ctpe = new CustomThreadPoolExecutor(4);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            ctpe.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " - Задача " + finalI + " Началась");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " - Задача " + finalI + " закончилась");
            });
        }
        ctpe.shutdown();
        ctpe.execute(() -> System.out.println("123123"));
    }

}

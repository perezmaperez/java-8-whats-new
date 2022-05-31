package com.perezma;

/**
 * This class converts an anonymous class into a Lambda expression using the Runnable interface.
 */
public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnableAnon = new Runnable() {
            @Override
            public void run() {
                 for (int i = 0 ; i < 3 ; i++) {
                    System.out.println(
                            "Hello world from Anon thread [" +
                            Thread.currentThread().getName() +
                            "]");
                }
            }
        };

        Runnable runnableLambda = () -> {
            for (int i = 0 ; i < 3 ; i++) {
                System.out.println(
                        "Hello world from Lambda thread [" +
                                Thread.currentThread().getName() +
                                "]");
            }
        };

        Thread ta = new Thread(runnableAnon);
        ta.start();
        ta.join();

        System.out.println();

        Thread tl = new Thread(runnableLambda);
        tl.start();
        tl.join();
    }
}

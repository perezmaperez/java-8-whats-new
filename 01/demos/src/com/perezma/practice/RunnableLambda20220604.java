package com.perezma.practice;

/**
 * This class converts an anonymous class into a Lambda expression by implementing the Runnable interface.
 */
public class RunnableLambda20220604 {

    public static void main(String[] args) throws InterruptedException {

        // Step 1: invoke three threads that prints the same text using the Runnable interface.

        Runnable runnableAnon = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 3; i++) {
                    System.out.println("Hello world from Anon thread [" +
                            Thread.currentThread().getName() +
                            "]");
                }
            }
        };

        // Step 2: Convert the anonymous class into a lambda expression

        Runnable runnableLambda = () -> {
            for(int i = 0; i < 3; i++) {
                System.out.println("Hello world from Lambda thread [" +
                        Thread.currentThread().getName() +
                        "]" );

            }
        };

        // Step 3: Start a thread that invokes the anonymous class

        Thread ta = new Thread(runnableAnon);
        ta.start();
        ta.join();

        // Step 4: Start a thread that invokes the lambda expression

        Thread tl = new Thread(runnableLambda);
        tl.start();
        tl.join();

    }
}

package com.carloguemes.multithreading;

public class Multithreading {
    public static void main(String[] args) throws InterruptedException {

//        MultithreadThing myThing  = new MultithreadThing();
//        MultithreadThing myThing2  = new MultithreadThing();
//        myThing.start();
//        myThing2.start();
//        myThing.run();
//        myThing2.run();
        
        /*
        .start() does multithreading, .run() does one thread after another
         */

        for (int i=0; i<=5; i++) {
            MultithreadThing myThing = new MultithreadThing(i);
            Thread myThread = new Thread(myThing);
            myThread.start(); // This will do five threads at the same time
            myThread.join();
            myThread.isAlive();

        }
    }
}

/*
it's better to implement the Runnable interface than extending Thread.
If you extend Thread you can't extend any other class, java doesn't allow multiple inheritance.
if you implement Runnable, you can still any other class, so it gives you more flexibility

There is also very useful methods from Thread
.join() it waits for a thread to die. Normally, when you start a thread the rest of the program will continue on, but if
for some reason you want your program to stop and wait for that thread to complete. So if you have one thread that you
want to wait for another to complete, you will use this method

.isAlive() this just returns a boolean true or false for weather the thread is currently still running
 */

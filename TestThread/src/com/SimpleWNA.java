package com;

public class SimpleWNA {
    final static Object instance = new Object();

    public static class T1 extends Thread {

        @Override
        public void run() {
            synchronized (instance) {
                System.out.println("T1 start! wait on object");
                try {
                    instance.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end!");
            }
        }
    }
    public static class T2 extends Thread {

        @Override
        public void run() {
            synchronized (instance) {
                System.out.println("T2 start! wait on object");
                instance.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end!");
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

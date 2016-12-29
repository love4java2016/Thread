package com;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {
    public static Integer calc(Integer para){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para*para;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(()->calc(50)).thenApply((i)->Integer.toString(i)).thenApply((str)->"\""+str+"\"").thenAccept(System.out::println);
       fu.get();
    }

}

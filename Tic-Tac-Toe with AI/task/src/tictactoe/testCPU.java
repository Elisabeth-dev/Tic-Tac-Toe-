package tictactoe;

import java.util.ArrayList;

public class testCPU {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(1000000);
        ArrayList<Integer> list2 = new ArrayList<>(1000000);
        ArrayList<Integer> list3 = new ArrayList<>(1000000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    list1.add(i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    list2.add(i);
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    list3.add(i);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());

    }
}

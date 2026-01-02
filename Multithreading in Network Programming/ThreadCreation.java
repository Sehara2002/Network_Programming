public class ThreadCreation{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyThread2());
        t2.start();

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("This is Thread 03");
            }
        });
        t3.start();


        Thread t4 = new Thread(()->{
            System.out.println("This is Thread 04");
        });
        t4.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("This is Thread 01");
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run(){
        System.out.println("This is Thread 02");
    }
}


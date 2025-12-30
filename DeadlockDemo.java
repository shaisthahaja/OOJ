class Resource1 {}
class Resource2 {}

public class DeadlockDemo {

    public static void main(String[] args) {

        Resource1 r1 = new Resource1();
        Resource2 r2 = new Resource2();

        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1 locked Resource 1");
                try { Thread.sleep(1000); } catch (Exception e) {}
                synchronized (r2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread 2 locked Resource 2");
                try { Thread.sleep(1000); } catch (Exception e) {}
                synchronized (r1) {
                    System.out.println("Thread 2 locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class CollegeThread extends Thread {
    String msg;
    int time;

    CollegeThread(String msg, int time) {
        this.msg = msg;
        this.time = time;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(msg);
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class threads {
    public static void main(String[] args) {
        CollegeThread t1 = new CollegeThread(
                "BMS College of Engineering", 10000);
        CollegeThread t2 = new CollegeThread(
                "CSE", 2000);

        t1.start();
        t2.start();
    }
}

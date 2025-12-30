import java.io.*;

class WriterThread extends Thread {
    PipedOutputStream out;

    WriterThread(PipedOutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            String msg = "Hello from Writer";
            out.write(msg.getBytes());
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class ReaderThread extends Thread {
    PipedInputStream in;

    ReaderThread(PipedInputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            int ch;
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

public class IPCDemo {
    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        new WriterThread(out).start();
        new ReaderThread(in).start();
    }
}

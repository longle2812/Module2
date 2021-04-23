public class NumberGenerator implements Runnable {
    private Thread myThread;
    String threadName;

    public NumberGenerator(String name) {
        this.threadName = name;
        System.out.println("Creating new Thread = " +myThread);
    }

    public void start(){
        this.myThread.start();
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " "+ this.hashCode());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("my thread is interupted");
        }
        System.out.println("my thread run is over");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        Thread thread1= new Thread(evenThread);
        Thread thread2 = new Thread(oddThread);
        thread1.start();
        thread1.join();
        thread2.start();
    }
}

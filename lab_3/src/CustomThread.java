public class CustomThread extends Thread {

    private volatile boolean running = true;

    public CustomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(getName() + ": працює. Мій пріоритет: " +  getPriority() + ";");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changePriority(int priority) {
        setPriority(priority);
        System.out.println(getName() + " пріоритет змінено на " + priority);
    }

    public void stopThread() {
        running = false;
    }
}
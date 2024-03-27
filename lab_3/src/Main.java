import java.util.Scanner;

public class Main {

    public static final String THREAD1_NAME = "t1";
    public static final String THREAD2_NAME = "t2";
    public static final String THREAD3_NAME = "t3";
    public static final String THREAD4_NAME = "t4";
    public static final String THREAD5_NAME = "t5";
    public static final String THREAD6_NAME = "t6";

    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread(THREAD1_NAME);
        CustomThread thread2 = new CustomThread(THREAD2_NAME);
        CustomThread thread3 = new CustomThread(THREAD3_NAME);
        CustomThread thread4 = new CustomThread(THREAD4_NAME);
        CustomThread thread5 = new CustomThread(THREAD5_NAME);
        CustomThread thread6 = new CustomThread(THREAD6_NAME);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        Scanner scanner = new Scanner(System.in);

        Thread priorityChangerThread = new Thread(() -> {
            while (true) {
                System.out.println("Введіть назву потоку, щоб змінити пріоритет (або введіть «exit», щоб вийти): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Введіть новий пріоритет (1-10): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();

                    if (input.equalsIgnoreCase("t1")) {
                        thread1.changePriority(priority);
                    } else if (input.equalsIgnoreCase("t2")) {
                        thread2.changePriority(priority);
                    }  else if (input.equalsIgnoreCase("t3")) {
                        thread3.changePriority(priority);
                    }  else if (input.equalsIgnoreCase("t4")) {
                        thread4.changePriority(priority);
                    }  else if (input.equalsIgnoreCase("t5")) {
                        thread5.changePriority(priority);
                    }  else if (input.equalsIgnoreCase("t6")) {
                        thread6.changePriority(priority);
                    } else {
                        System.out.println("Недійсна назва потоку!");
                    }
                }
            }
            scanner.close();
        });
        priorityChangerThread.start();

        try {
            priorityChangerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.stopThread();
        thread2.stopThread();
        thread3.stopThread();
        thread4.stopThread();
        thread5.stopThread();
        thread6.stopThread();
    }
}
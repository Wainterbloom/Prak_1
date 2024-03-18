package Prak2;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        int number = 0;
        while (listOfNumbers.size() < 50) {
            listOfNumbers.add(number++);
            System.out.println("Записали: " + number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


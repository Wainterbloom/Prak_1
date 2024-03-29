package Prak2;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            if (!listOfNumbers.isEmpty()) {
                System.out.println("Прочитали: " + listOfNumbers.get(listOfNumbers.size() - 1));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


package Prak2;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Reader reader = new Reader(listOfNumbers);
        Writer writer = new Writer(listOfNumbers);

        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);

        writerThread.start();
        readerThread.start();
    }
}
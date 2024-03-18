package Prak3;

import java.util.Random;

public class Citizen implements Runnable {
    private boolean isServed = false;
    String category;

    public Citizen(String category) {
        this.category = category;
    }

    public boolean isServed() {
        return isServed;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int windowIndex = rand.nextInt(3); // Случайное распределение по окнам

        if (windowIndex == 0 || (windowIndex == 1 && category.equals("пожилые")) ||
                (windowIndex == 2 && category.equals("бизнесмены"))) {
            System.out.println( category + " обслужен в окне " + windowIndex);
            isServed = true;
        } else {
            System.out.println( category + " свалил из очереди.");
        }
    }
}
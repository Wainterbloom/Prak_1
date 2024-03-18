package Prak3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int totalCitizens = 100;
        int elderlyLeft = 0;
        int businessmenLeft = 0;

        for (int i = 0; i < totalCitizens; i++) {
            Citizen citizen;
            if (i % 3 == 0) {
                citizen = new Citizen("молодые");
            } else if (i % 3 == 1) {
                citizen = new Citizen("пожилые");
            } else {
                citizen = new Citizen("бизнесмены");
            }
            executor.execute(citizen);
            if (!citizen.isServed()) {
                if (citizen.category.equals("пожилые")) elderlyLeft++;
                if (citizen.category.equals("бизнесмены")) businessmenLeft++;
            }
        }

        executor.shutdown();

        double elderlyLeftPercent = (double) elderlyLeft / (totalCitizens / 3) * 100;
        double businessmenLeftPercent = (double) businessmenLeft / (totalCitizens / 3) * 100;

        System.out.println("Процент ушедших пожилых: " + elderlyLeftPercent + "%");
        System.out.println("Процент ушедших бизнесменов: " + businessmenLeftPercent + "%");
    }
}


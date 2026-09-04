import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        int monthIndex = monthNumber - 1;

            while(monthNumber < 1 || monthNumber > 12) {
                System.out.println("Неверный номер месяца. Введите номер еще раз:");
                monthNumber = scanner.nextInt();
                monthIndex = monthNumber - 1;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = scanner.nextInt();
        int dayIndex = dayNumber - 1;

            while (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Неверный номер дня. Введите номер еще раз:");
                dayNumber = scanner.nextInt();
                dayIndex = dayNumber - 1;

        }
        System.out.println("Введите количество шагов");
        int stepsCount = scanner.nextInt();

            while (stepsCount < 0) {
            System.out.println("Указано неверное количество шагов. Введите количество еще раз:");
                stepsCount = scanner.nextInt();
        }

        if ((monthNumber >= 1 || monthNumber <= 12) && (dayNumber >= 1 || dayNumber <= 30) && (stepsCount >= 0)) {
            MonthData monthData = monthToData[monthIndex];
            monthData.days[dayIndex] = stepsCount;
        }
    }

    public int goalByStepsPerDay = 10000;

    void changeStepGoal(){
        System.out.println("Введите значение новой цели количества шагов за день:");
        goalByStepsPerDay = scanner.nextInt();
        while(goalByStepsPerDay<=0){
            System.out.println("Цель должна быть больше нуля! Введите значение еще раз:");
            goalByStepsPerDay = scanner.nextInt();
        }
    }

     void printStatistic() {
        System.out.println("Введите номер месяца\n" +
                "1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        int monthNumber = scanner.nextInt();
        int monthIndex = monthNumber - 1;
        while (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Неверный номер месяца. Введите номер еще раз:");
            monthNumber = scanner.nextInt();
            monthIndex = monthNumber - 1;
        }

        MonthData monthData = monthToData[monthIndex];

        monthData.printDaysAndStepsFromMonth(monthData);

        int sumSteps = monthData.sumStepsFromMonth(monthData);
        System.out.println("*** Общее количество шагов за месяц: " + sumSteps);

        int maxSteps = monthData.maxSteps(monthData);
        System.out.println("*** Максимальное пройденное количество шагов за месяц: " + maxSteps);

        int averageSteps = monthData.averageSteps(monthData);
        System.out.println("*** Среднее количество шагов: " + averageSteps);

        // Converter converter = new Converter();
        // int distanceInKm = converter.convertToKm(sumSteps);
         System.out.println("*** Пройденная дистанция (в км): " + Converter.convertToKm(sumSteps));

         // int kilocalories = converter.convertStepsToKilocalories(sumSteps);
         System.out.println("*** Количество сожжённых килокалорий: " + Converter.convertStepsToKilocalories(sumSteps));

         //int bestseries = monthData.bestSeries(monthData,goalByStepsPerDay);
         System.out.println("*** Лучшая серия: " + monthData.bestSeries(monthData,goalByStepsPerDay));

         System.out.println();
    }
}

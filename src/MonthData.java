public class MonthData {

    int[] days = new int[30];

    public void printDaysAndStepsFromMonth(MonthData monthData) {
        for (int j = 0; j < monthData.days.length; j++) {
            System.out.println((j + 1) + "-й день: "+ monthData.days[j]);
        }
    }

    int sumStepsFromMonth(MonthData monthData) {
        int sumSteps = 0;

        for (int day : monthData.days) {
            sumSteps = sumSteps + day;
            }
       return sumSteps;
   }

     int maxSteps(MonthData monthData){
         int maxSteps = 0;

         for(int day : monthData.days) {
             if (day > maxSteps) {
                 maxSteps = day;
             }
         }
         return maxSteps;
     }

    int averageSteps(MonthData monthData){
        int sumSteps = 0;
        int averageSteps = 0;

        for(int day : monthData.days) {
            sumSteps += day;
        }
        averageSteps = sumSteps / 30;
        return averageSteps;
    }

    int bestSeries(MonthData monthData, int goal){
        int currentSeries = 0;
        int finalSeries = 0;

        for(int day : monthData.days){
            if(day >= goal){
                    currentSeries++;
                    if (currentSeries > finalSeries) {
                        finalSeries = currentSeries;
                    }
                } else {
                    currentSeries = 0;
                }
            }
        return finalSeries;
    }

}

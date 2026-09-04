public class Converter {
    static int SmInStep = 75;
    static int SmInKm = 100000;
    static int KilocalInStep = 50;
    static int CalInKilocal = 1000;

    static int convertToKm(int steps){
        int distanceInKm = (steps * SmInStep) / SmInKm;
        return distanceInKm;
    }

    static int convertStepsToKilocalories(int steps){
        int kilocalories = (steps * KilocalInStep) / CalInKilocal;
        return kilocalories;
    }
}

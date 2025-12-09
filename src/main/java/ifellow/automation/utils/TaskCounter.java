package ifellow.automation.utils;

public class TaskCounter {
    public static int increaseCounter(String counter) {
        return currentCounter(counter) + 1;
    }

    public static int currentCounter(String counter) {
        String[] arrCounter = counter.split(" ");
        return Integer.parseInt(arrCounter[arrCounter.length - 1]);
    }
}

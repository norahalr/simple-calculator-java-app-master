package nl.ordina;

public class Calculator {
    private Calculator() {
    }

    public static Integer add(Integer fist, Integer second) {
        return fist + second;
    }

    public static Integer multiply(Integer first, Integer second) {
        return first * second;
    }

    public static Integer substract(Integer first, Integer second) {
        return first - second;
    }

    public static Integer devide(Integer first, Integer second) {
        return first / second;
    }
}

package ru.vtb.t1.course.homework1.exception;

public class PriorityNotValidException extends RuntimeException {

    private static String MESSAGE = "Значение priority должно быть от 1 до 10, в методе %s priority равен %s";
    public PriorityNotValidException(int priority, String methodName) {
        super(String.format(MESSAGE, methodName, priority));
    }
}

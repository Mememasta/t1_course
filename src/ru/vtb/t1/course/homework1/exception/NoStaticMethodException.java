package ru.vtb.t1.course.homework1.exception;

public class NoStaticMethodException extends RuntimeException {

    private static final String MESSAGE = "Метод %s не является статическим";

    public NoStaticMethodException(String methodName) {
        super(String.format(MESSAGE, methodName));
    }
}

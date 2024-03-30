package ru.vtb.t1.course.homework1.exception;

public class RunMethodException extends RuntimeException {

    private static final String MESSAGE = "Не удалось запустить метод %s.%s";

    public RunMethodException(String className, String methodName, Throwable t) {
        super(String.format(MESSAGE, className, methodName), t);
    }
}

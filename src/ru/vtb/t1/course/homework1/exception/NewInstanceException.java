package ru.vtb.t1.course.homework1.exception;

public class NewInstanceException extends RuntimeException {

    private static final String MESSAGE = "Не удалось создать объект %s";

    public NewInstanceException(String className, Throwable t) {
        super(String.format(MESSAGE, className), t);
    }
}
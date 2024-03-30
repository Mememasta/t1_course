package ru.vtb.t1.course.homework1.exception;

public class AnnotatedMethodsOutOfRangeException extends RuntimeException {

    private static final String MESSAGE = "Методов помеченных аннотацией %s должно быть не больше 1";

    public AnnotatedMethodsOutOfRangeException(String annotationName) {
        super(String.format(MESSAGE, annotationName));
    }
}
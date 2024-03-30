package ru.vtb.t1.course.homework1.test;

import ru.vtb.t1.course.homework1.annotation.*;
import ru.vtb.t1.course.homework1.exception.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;

public class TestRunner {

    private TestRunner() {
    }

    public static <T> void runTests(Class<T> clazz) {
        var obj = newInstance(clazz);
        runMethodsAnnotated(clazz, obj);
    }

    private static <T> void runMethodsAnnotated(Class<T> clazz, Object obj) {
        var testAnnotationMethods = new ArrayList<Method>();
        var beforeSuiteAnnotationMethods = new ArrayList<Method>();
        var afterSuiteAnnotationMethods = new ArrayList<Method>();
        var beforeTestAnnotationMethods = new ArrayList<Method>();
        var afterTestAnnotationMethods = new ArrayList<Method>();
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Test.class) && isValidAnnotationPriority(declaredMethod)) {
                testAnnotationMethods.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(BeforeSuite.class)) {
                if (!Modifier.isStatic(declaredMethod.getModifiers())) {
                    throw new NoStaticMethodException(declaredMethod.getName());
                }
                beforeSuiteAnnotationMethods.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(AfterSuite.class)) {
                if (!Modifier.isStatic(declaredMethod.getModifiers())) {
                    throw new NoStaticMethodException(declaredMethod.getName());
                }
                afterSuiteAnnotationMethods.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(BeforeTest.class)) {
                beforeTestAnnotationMethods.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(AfterTest.class)) {
                afterTestAnnotationMethods.add(declaredMethod);
            }
        }
        if (isValidAnnotationSuit(afterSuiteAnnotationMethods, AfterSuite.class.getSimpleName()) &&
                isValidAnnotationSuit(beforeSuiteAnnotationMethods, BeforeSuite.class.getSimpleName())
        ) {
            runStaticMethod(obj, beforeSuiteAnnotationMethods, TestRunner::runBefore, TestRunner::runAfter, beforeTestAnnotationMethods, afterTestAnnotationMethods);
            runMethod(obj, testAnnotationMethods, TestRunner::runBefore, TestRunner::runAfter, beforeTestAnnotationMethods, afterTestAnnotationMethods);
            runStaticMethod(obj, afterSuiteAnnotationMethods, TestRunner::runBefore, TestRunner::runAfter, beforeTestAnnotationMethods, afterTestAnnotationMethods);
        }
    }

    private static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new NewInstanceException(clazz.getName(), e);
        }
    }

    private static <T> void runBefore(T obj, List<Method> methods) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("BeforeTest - ");
        methods.forEach(method -> run(obj, method));
        System.out.println();
    }

    private static <T> void runAfter(T obj, List<Method> methods) {
        System.out.println();
        System.out.print("AfterTest - ");
        methods.forEach(method -> run(obj, method));
    }

    private static <T> void runMethod(T obj, List<Method> methods, BiConsumer<T, List<Method>> beforeFunc, BiConsumer<T, List<Method>> afterFunc, List<Method> beforeTestAnnotationMethods, List<Method> afterTestAnnotationMethods) {
        methods.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(method -> method.getAnnotation(Test.class).priority())))
                .forEach(method -> {
                    beforeFunc.accept(obj, beforeTestAnnotationMethods);
                    run(obj, method);
                    afterFunc.accept(obj, afterTestAnnotationMethods);
                });
    }

    private static <T> void runStaticMethod(T obj, List<Method> methods, BiConsumer<T, List<Method>> beforeFunc, BiConsumer<T, List<Method>> afterFunc, List<Method> beforeTestAnnotationMethods, List<Method> afterTestAnnotationMethods) {
        if (methods.isEmpty()) {
            return;
        }
        var method = methods.get(0);
        beforeFunc.accept(obj, beforeTestAnnotationMethods);
        run(obj, method);
        afterFunc.accept(obj, afterTestAnnotationMethods);
    }

    private static <T> void run(T obj, Method method) {
        try {
            method.invoke(obj);
        } catch (Exception e) {
            throw new RunMethodException(obj.getClass().getName(), method.getName(), e);
        }
    }

    private static boolean isValidAnnotationPriority(Method method) {
        var annotation = method.getAnnotation(Test.class);
        if (annotation == null) {
            return false;
        }
        if (annotation.priority() >= 1 && annotation.priority() <= 10) {
            return true;
        }
        throw new PriorityNotValidException(annotation.priority(), method.getName());
    }

    private static boolean isValidAnnotationSuit(List<Method> methods, String annotationName) {
        if (methods.size() > 1) {
            throw new AnnotatedMethodsOutOfRangeException(annotationName);
        }
        return true;
    }
}

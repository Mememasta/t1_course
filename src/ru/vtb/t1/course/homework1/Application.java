package ru.vtb.t1.course.homework1;

import ru.vtb.t1.course.homework1.service.InnoService;
import ru.vtb.t1.course.homework1.test.TestRunner;

public class Application {

    public static void main(String[] args) {
        TestRunner.runTests(InnoService.class);
    }

}

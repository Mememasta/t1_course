package ru.vtb.t1.course.homework1.service;

import ru.vtb.t1.course.homework1.annotation.*;

public class InnoService {

    @BeforeSuite
    public static void newsletterStartWorkDay() {
        System.out.println("newsletter about the start of the working day");
    }

    @AfterSuite
    public static void newsletterEndWorkDay() {
        System.out.println("newsletter at the end of the working day");
    }

    @Test(priority = 1)
    public void callСolleagues() {
        System.out.println("call colleagues");
    }

    @Test(priority = 10)
    public void takeWorkPlace() {
        System.out.println("take a workplace");
    }

    @BeforeTest
    public void employeeMonitoringOn() {
        System.out.println("start monitor employee work");
    }

    @AfterTest
    public void employeeMonitoringOff() {
        System.out.println("stop monitor employee work");
    }
}

package ru.vtb.t1.course;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.vtb.t1.course.model.UserDTO;
import ru.vtb.t1.course.service.UserService;

@ComponentScan
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);

        var firstUser = new UserDTO(1L, "Марат");
        var lastUser = new UserDTO(2L, "Павел");
        userService.save(firstUser);
        userService.save(lastUser);

        var foundUser = userService.findById(firstUser.getId());
        var foundUsers = userService.findAll();

        userService.deleteById(firstUser.getId());
        userService.deleteById(lastUser.getId());
        System.out.println(foundUser);
        System.out.println(foundUsers);
    }
}

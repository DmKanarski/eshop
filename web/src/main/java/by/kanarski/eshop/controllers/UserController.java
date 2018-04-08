package by.kanarski.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public ConfirmationUser registerUser(UserRegistrationForm userRegistrationForm, BindingResult bindingResult) {
        return userService.registerUser(userRegistrationForm);
    }

}

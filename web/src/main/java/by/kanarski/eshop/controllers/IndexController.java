package by.kanarski.eshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Controller
@RequestMapping(path = "")
public class IndexController {

    @GetMapping
    public String toIndex() {
        return "index";
    }

}

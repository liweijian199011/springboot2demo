package com.jack.controller;

import com.jack.entity.User;
import com.jack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/13.
 *
 * @author liweijian.
 */
@Controller
@RequestMapping("/user")
public class UserController implements EnvironmentAware {

    private int i = 0;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> listUser(Integer id) {
        List<User> userList = userService.listUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public void print() {
        System.out.println("i=" + i++);
    }

    public void printService() {
        System.out.println(userService.toString());
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result == 1 ? new ResponseEntity<String>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
    }

    private Environment environment = null;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

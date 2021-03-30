package com.audit.automator.controllers;

import com.audit.automator.pojo.UserCreationRequest;
import com.audit.automator.service.UserService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignUp {


    private UserService service;

    @Autowired
    public SignUp(UserService userService) {
        this.service = userService;
    }

    @GetMapping
    public List<UserCreationRequest> getStudentDetails(){
        return List.of( new UserCreationRequest("1000L", "Ayodele", "oluwabusola.ayodele@gmail.com", "24", "198765", "25", "29876etrf", "192873678290-", "0918765627890"));
    }

    @PostMapping("/signup")
    public void createUser(@RequestBody UserCreationRequest request){
        service.createUser(request);

    }
}

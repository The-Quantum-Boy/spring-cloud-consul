package com.user.user.controller;


import com.user.user.exception.DataNotFoundException;
import com.user.user.exception.Error;
import com.user.user.model.User;
import com.user.user.model.UserResponse;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    public UserService userService;

    @GetMapping(value = "/getUserDetailsById",produces = "application/json")
    public ResponseEntity<UserResponse> getUserDetailsById(@RequestParam String  id){
        UserResponse userResponse;

        try {
            User user = userService.fetchUserById(Integer.parseInt(id));
            userResponse=new UserResponse(user,null);


        }catch (DataNotFoundException e){
            Error error=new Error(e.getMessage());
            userResponse=new UserResponse(null,error);
        }

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/getUserByDeptId",produces = "application/json")
    public ResponseEntity<UserResponse> getUserByDeptId(@RequestParam String  id){
        UserResponse userResponse;

        try {
            User user = userService.fetchUserByDepartment(Integer.parseInt(id));
            userResponse=new UserResponse(user,null);


        }catch (DataNotFoundException e){
            Error error=new Error(e.getMessage());
            userResponse=new UserResponse(null,error);
        }

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}

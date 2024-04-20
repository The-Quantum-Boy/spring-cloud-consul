package com.user.user.service.impl;

import com.user.user.exception.DataNotFoundException;
import com.user.user.model.User;
import com.user.user.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    List<User> userList;

    @PostConstruct
    public void createUsers(){
        this.userList=List.of(
                new User(1,"sumit","dhanasdforakr",new Date(2000, Calendar.DECEMBER,11),12),
                new User(3,"amit","asdfasdf",new Date(2000, Calendar.JANUARY,12),15),
                new User(4,"niraj","asdfads",new Date(2000, Calendar.JULY,12),14),
                new User(5,"chhapri","asdf234",new Date(2000, Calendar.AUGUST,12),13)
        );

    }


    public User fetchUserByDepartment(int departmentId) throws DataNotFoundException {
        return userList.stream()
                .filter(u ->  u.departmentNo()==departmentId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("User not found in this department"));
    }

    @Override
    public User fetchUserById(int userId) throws DataNotFoundException {
        return this.userList.stream()
                .filter(u->u.id()==userId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("user not found with this id"));
    }
}

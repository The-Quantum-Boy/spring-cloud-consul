package com.user.user.service;

import com.user.user.exception.DataNotFoundException;
import com.user.user.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    User fetchUserByDepartment(int departmentId) throws  DataNotFoundException;

    User fetchUserById(int userId) throws DataNotFoundException;
}

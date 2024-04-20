package com.dept.service;

import com.dept.exception.DataNotFoundException;
import com.dept.model.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentService {

    Department getDeptDetailsById(int deptId) throws DataNotFoundException;
}

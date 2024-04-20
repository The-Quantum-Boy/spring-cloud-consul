package com.dept.service.impl;

import com.dept.exception.DataNotFoundException;
import com.dept.model.Department;
import com.dept.service.DepartmentService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService {


    List<Department> deptList;

    @PostConstruct
    public void createDepartmentData(){
        this.deptList=List.of(
                new Department(12,"HR"),
                new Department(13,"Development"),
                new Department(14,"DevOps"),
                new Department(15,"UAT")

        );
    }

    @Override
    public Department getDeptDetailsById(int deptId) throws DataNotFoundException {
        return this.deptList.stream()
                .filter(d->d.deptId()==deptId)
                .findFirst()
                .orElseThrow(()->new DataNotFoundException("Department with this id not found."));
    }
}

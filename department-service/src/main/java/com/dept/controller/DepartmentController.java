package com.dept.controller;

import com.dept.exception.DataNotFoundException;
import com.dept.exception.Error;
import com.dept.model.Department;
import com.dept.model.DepartmentResponse;
import com.dept.service.DepartmentService;
import com.dept.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @Autowired
    public UserClientService userClientService;


    @GetMapping(value = "/getDeptById",produces = "application/json")
    public ResponseEntity<DepartmentResponse> getDeptDetailsById(@RequestParam int id){
        DepartmentResponse departmentResponse;
        try{

            Department department=departmentService.getDeptDetailsById(id);
            departmentResponse=new DepartmentResponse(department,null);

        }catch(DataNotFoundException e){
            departmentResponse=new DepartmentResponse(null,new Error(e.getMessage()));
        }

        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }


    @GetMapping(value = "/getUserByDeptId",produces = "application/json")
    public ResponseEntity<String > getUserByDeptId(@RequestParam String id){
       return userClientService.getUserByDepartmentId(id);
    }





}

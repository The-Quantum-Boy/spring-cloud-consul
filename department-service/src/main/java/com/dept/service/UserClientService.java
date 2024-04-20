package com.dept.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("user-service")
public interface UserClientService {

    @GetMapping("/user/getUserByDeptId")
    ResponseEntity<String> getUserByDepartmentId(@RequestParam String id);

}

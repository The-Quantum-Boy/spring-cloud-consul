package com.dept.model;

import com.dept.exception.Error;

public record DepartmentResponse(Department department, Error error) {
}

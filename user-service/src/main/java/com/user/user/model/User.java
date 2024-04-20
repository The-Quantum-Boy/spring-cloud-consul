package com.user.user.model;

import java.util.Date;

public record User(int id , String firstName, String lastName, Date dob,int departmentNo) {
}

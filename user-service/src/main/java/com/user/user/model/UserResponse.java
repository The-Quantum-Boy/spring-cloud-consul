package com.user.user.model;

import com.user.user.exception.Error;

public record UserResponse(User user, Error error) {
}
